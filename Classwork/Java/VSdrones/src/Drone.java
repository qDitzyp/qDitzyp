public class Drone extends Thread{
    public static int speed = 500;
    public static int capacity = 1;
    public static int interval = 3;
    private double tripStart;
    private double tripEnd;
    private int droneNumber;
    
    public Drone(double tripStart, int droneNumber){
        this.tripStart = tripStart;
        this.droneNumber = droneNumber;
    }
    
    public void run(){
        tripEnd = tripStart + App.totalDistance/500;
        App.droneTimes.add(new Events(tripEnd, ("DRONE#" + droneNumber)));
    }


}
