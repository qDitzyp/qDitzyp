public class Truck extends Thread {
    
    public static int speed = 30;
    public static int capacity = 10;
    public static int interval = 15;
    public Double tripTime;
    private double tripStart;
    private double tripEnd;
    public int truckNumber;
    public boolean atCrossing = false;
    public int crossingNum;
    public boolean hasBefore = false;
    private boolean secondCrossing = false;
    public boolean last = false;
    public double leftTrack;
    public boolean behind = false;
    
    public Truck(double tripStart, int truckNumber){
        this.tripStart = tripStart;
        this.tripTime = tripStart;
        this.truckNumber = truckNumber;
    }
    
    public void run(){
        App.eventList.add(new Events(tripStart, (": TRUCK#"+truckNumber+" begins journey")));
        if(behind == false){
            tripTime = tripTime + App.trackDistance/30;
        }
        //this is the main loop for the trucks to check if they are at a crossing and such
        do{
            //this checks to see if this is this trucks second time at a crossing
            if(atCrossing == true){
                secondCrossing = true;
            }
            atCrossing = false;
            //this checks if there is a queue of trucks in between train times, giving this truck a number correlating to that queue and changing it to show its at the crossing
            if(secondCrossing == false){
                for(int i = 0; i<App.trainStarts.size(); i++){
                    if((i+1) < App.trainStarts.size()){
                        if(tripTime<App.trainStarts.get(i+1) && tripTime>App.trainEnds.get(i)){
                            crossingNum = i+1;
                            if(App.crossingLines.get(crossingNum).size() != 0){
                                atCrossing = true;
                            }
                        }
                    }
                }
            }
            //this checks if the train will be at the crossing at the time that this truck gets there, if so it will change it to show that it is at a crossing, and give it a number which correlates to a crossing queue
            if(atCrossing == false){
                for(int i = 0; i<App.trainStarts.size(); i++){
                    if(tripTime>App.trainStarts.get(i) && tripTime<App.trainEnds.get(i)){
                        atCrossing = true;
                        crossingNum = i;
                    }
                }
            }
            //this is for the trucks that haven't stopped at a crossing before and adds an event to the eventList for it, it then adds the truck to the correct queue and if its the last one it notifies the mainSim before waiting
            if(atCrossing == true && hasBefore == false){
                App.eventList.add(new Events(tripTime, (": TRUCK#"+truckNumber+" waits at crossing")));
                hasBefore = true;
                tripTime = App.trainEnds.get(crossingNum);
                App.crossingLines.get(crossingNum).addLast(this);
                if(this.last == true){
                    this.last = false;
                    if(App.mainSim.isAlive()==false){
                        App.mainSim.start();
                    }else{
                        synchronized(App.mainSim){
                            App.mainSim.notify();
                        }
                    }
                }
                synchronized (this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            //this is for trucks that have stopped at a crossing previously
            if(atCrossing == true && secondCrossing == true){
                tripTime = App.trainEnds.get(crossingNum);
                App.crossingLines.get(crossingNum).addLast(this);
                if(this.last == true){
                    this.last = false;
                    synchronized(App.mainSim){
                        App.mainSim.notify();
                    }
                }
                synchronized (this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }while(atCrossing == true);
        //this all adds the final values for the trucks to the eventList in main, then if this is the last truck in the last it notifies the mainSim before dying
        App.eventList.add(new Events(tripTime, (": TRUCK#"+truckNumber+" crosses crossing")));
        tripTime = tripTime + App.trackEnd/30;
        tripEnd = tripTime;
        App.eventList.add(new Events(tripTime, (": TRUCK#"+truckNumber+" completes journey")));
        App.totalTruckTime.add(new Events(tripEnd-tripStart, ("TRUCK #" +truckNumber+ " total trip time: ")));
        if(last == true){
            synchronized(App.mainSim){
                App.mainSim.notify();
            }
        }
    }

}
