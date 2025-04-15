import java.util.ArrayList;
public class TruckSim extends Thread{
    private double percentage;
    private double packages;
    public TruckSim(double percentage, double packages){
        this.percentage = percentage;
        this.packages = packages;
    }
    public void run(){
        boolean empty = false;
        int clearList = 0;
        //this is the main loops of the sim, creating more trucks and checking which ones are waiting at the crossing
        while (empty == false){
            int crossingAdd = 1;
            empty = true;
            int counter = App.trucks.size();

            //this checks all the queues to see if they are empty, if one is not it exits the loop, with clearList being set to the list that still has trucks in it
            for(int i = clearList; i<App.crossingLines.size(); i++){
                if(App.crossingLines.get(i).size() != 0){
                    empty = false;
                    clearList = i;
                    break;
                }
            }
            //this breaks out of the main loop if all lists are empty
            if(empty == true){
                break;
            }
            //this creates trucks that would possibly interact with the existing trucks, if there are no more trains left it keeps adding until it is out of packages
            if(App.trainEnds.size() >= clearList+2){
                while(App.truckPackages > 0 && (App.truckClock + (App.trackDistance/Truck.speed)) < App.trainEnds.get(clearList+1)){
                    App.trucks.add(new Truck(App.truckClock, App.truckNumber+1));
                    App.truckPackages = App.truckPackages-Truck.capacity;
                    App.truckNumber++;
                    App.truckClock = App.truckClock+Truck.interval;
                }
            }else{
                while(App.truckPackages > 0){
                    App.trucks.add(new Truck(App.truckClock, App.truckNumber+1));
                    App.truckPackages = App.truckPackages-Truck.capacity;
                    App.truckNumber++;
                    App.truckClock = App.truckClock+Truck.interval;
                }
            }
            if(App.truckPackages<0){
                App.trucks.get(App.trucks.size()-1).last = true;
            }
            //this removes each truck from the queue and notifies them (just changed so it also adds the time to each of the trucks based upon how many trucks are in front of it)
            ArrayList<Double> checkingNums = new ArrayList<Double>();
            for(int i = App.crossingLines.get(clearList).size(); i>0 ; i--){
                try {
                    TruckSim.sleep(500);
                } catch (InterruptedException e) {
                }
                //this is made in such a way that if the truck is going to end up in the next train queue they are removed from the current queue so they are in the correct order for the next queue its a little confusing because I didn't have time to clean it out
                if(clearList < App.trainStarts.size()-1){
                    if((App.crossingLines.get(clearList).getFirst().tripTime + crossingAdd) > App.trainStarts.get(clearList+1)){
                        checkingNums.add(App.crossingLines.get(clearList).getFirst().tripTime);
                        App.crossingLines.get(clearList).getFirst().tripTime = App.crossingLines.get(clearList).getFirst().tripTime + crossingAdd;
                        crossingAdd++;
                        if(App.crossingLines.get(clearList).getFirst() == App.trucks.get(App.trucks.size()-1)){
                            App.crossingLines.get(clearList).getFirst().last = true;
                            synchronized (App.crossingLines.get(clearList).getFirst()){
                                App.crossingLines.get(clearList).removeFirst().notify();
                            }
                            synchronized (this){
                                try {
                                    this.wait();
                                } catch (InterruptedException e) {
                                }
                            }   
                        }else if(App.crossingLines.get(clearList).size() == 1){
                            App.crossingLines.get(clearList).getFirst().last = true;
                            synchronized (App.crossingLines.get(clearList).getFirst()){
                                App.crossingLines.get(clearList).removeFirst().notify();
                            }
                            synchronized (this){
                                try {
                                    this.wait();
                                } catch (InterruptedException e) {
                                }
                            }   
                        }else{
                            synchronized (App.crossingLines.get(clearList).getFirst()){
                                App.crossingLines.get(clearList).removeFirst().notify();
                            }
                        }
                    }else{
                        App.crossingLines.get(clearList).getFirst().tripTime = App.crossingLines.get(clearList).getFirst().tripTime + crossingAdd;
                        checkingNums.add(App.crossingLines.get(clearList).getFirst().tripTime);
                        if(App.crossingLines.get(clearList).size() == 1){
                            checkingNums.sort(null);
                            int b = 1;
                            for(int c = counter; c<App.trucks.size();c++){
                                if(checkingNums.get(checkingNums.size()-1) > (App.trucks.get(c).tripTime +(App.trackDistance/Truck.speed))){
                                    App.trucks.get(c).tripTime = App.trucks.get(c).tripTime + (App.trackDistance/Truck.speed);
                                    App.eventList.add(new Events(App.trucks.get(c).tripTime, (": TRUCK#"+App.trucks.get(c).truckNumber+" waits at crossing")));
                                    App.trucks.get(c).hasBefore = true;
                                    App.trucks.get(c).tripTime = checkingNums.get(checkingNums.size()-1) + b;
                                    b++;
                                    
                                }
                            }
                            synchronized (App.crossingLines.get(clearList).getFirst()){
                                App.crossingLines.get(clearList).removeFirst().notify();
                            }
                        }else{
                            synchronized (App.crossingLines.get(clearList).getFirst()){
                                App.crossingLines.get(clearList).removeFirst().notify();
                            }
                        }
                        crossingAdd++;
                    }
                }else{
                    App.crossingLines.get(clearList).getFirst().tripTime = App.crossingLines.get(clearList).getFirst().tripTime + crossingAdd;
                    checkingNums.add(App.crossingLines.get(clearList).getFirst().tripTime);
                    if(App.crossingLines.get(clearList).size() == 1){
                        checkingNums.sort(null);
                        int b = 1;
                        for(int c = counter; c<App.trucks.size();c++){
                            if(checkingNums.get(checkingNums.size()-1) > (App.trucks.get(c).tripTime +(App.trackDistance/Truck.speed))){
                                App.trucks.get(c).tripTime = App.trucks.get(c).tripTime + (App.trackDistance/Truck.speed);
                                App.eventList.add(new Events(App.trucks.get(c).tripTime, (": TRUCK#"+App.trucks.get(c).truckNumber+" waits at crossing")));
                                App.trucks.get(c).hasBefore = true;
                                App.trucks.get(c).tripTime = checkingNums.get(checkingNums.size()-1) + b;
                                b++;
                                
                            }
                        }
                        synchronized (App.crossingLines.get(clearList).getFirst()){
                            App.crossingLines.get(clearList).removeFirst().notify();
                        }
                    }else{
                        synchronized (App.crossingLines.get(clearList).getFirst()){
                            App.crossingLines.get(clearList).removeFirst().notify();
                        }
                    }
                    crossingAdd++;
                }
            }
            App.trucks.get(App.trucks.size()-1).last = true;
            for(int c = counter; c<App.trucks.size();c++){
                if(App.trucks.get(c).isAlive() == false){
                    try {
                        TruckSim.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    App.trucks.get(c).start();
                }
            }
            synchronized (this){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }   
        }
        App.eventList.sort(null);
        System.out.println("With " +percentage+ "% drones and " +packages+ " packages,"+ "\n" + "There will be:" + "\n" + "-" + App.drones.size() + " drones" + "\n" + "-" + App.trucks.size() + " trucks");
        System.out.println("\n"+ "TRAIN SCHEDULE" + "\n" + "-------");
        for(int i = 0; i < App.trainStarts.size(); i++){
            System.out.println(App.trainStarts.get(i) + "-" + App.trainEnds.get(i));
        }
        for(int b = 0; b<App.eventList.size(); b++){
            System.out.println(App.eventList.get(b).toString(1));
        }
        System.out.println("\n"+ "STATS" + "\n" + "-------");
        for(int b = 0; b<App.totalTruckTime.size(); b++){
            System.out.println(App.totalTruckTime.get(b).toString(2));
        }
        double truckAv = 0;
        for(int i = 0; i<App.trucks.size(); i++){
            truckAv = truckAv + App.trucks.get(i).tripTime;
        }
        truckAv = truckAv/App.trucks.size();
        System.out.println("\n" + "TRUCK AVG TRIP TIME: " + truckAv + " minutes");
        System.out.println("TRUCK TOTAL TIME: " + App.trucks.get(App.trucks.size()-1).tripTime + " minutes");
        System.out.println("\n" + "DRONE TRIP TIME: " + App.totalDistance/Drone.speed + " minutes");
        App.droneTimes.sort(null);
        System.out.println("DRONE TOTAL TIME: " + App.droneTimes.get(App.droneTimes.size()-1).eventTime + " minutes");
        if(App.trucks.get(App.trucks.size()-1).tripTime > App.droneTimes.get(App.droneTimes.size()-1).eventTime){
            System.out.println("\n" + "TOTAL TIME: " + App.trucks.get(App.trucks.size()-1).tripTime + " minutes");
        }else{
            System.out.println("\n" + "TOTAL TIME: " + App.droneTimes.get(App.droneTimes.size()-1).eventTime + " minutes");
        }
    }
}
