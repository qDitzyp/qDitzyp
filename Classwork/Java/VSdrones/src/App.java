import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
public class App {
    //if you are wondering why there is a million variables here it's because some of these I had to move up here once I realized I wanted to use them other places, but it felt more convenient to keep them here
    public static ArrayList<Events> eventList= new ArrayList<Events>();
    public static ArrayList<Events> totalTruckTime = new ArrayList<Events>();
    public static ArrayList<Events> droneTimes = new ArrayList<Events>();
    public static ArrayList<Double> trainStarts = new ArrayList<Double>();
    public static ArrayList<Double> trainEnds = new ArrayList<Double>();
    public static ArrayList<ArrayDeque<Truck>> crossingLines = new ArrayList<ArrayDeque<Truck>>();
    public static ArrayList<Drone> drones = new ArrayList<Drone>();
    public static ArrayList<Truck> trucks = new ArrayList<Truck>();
    public static int totalDistance = 30000;
    public static int trackDistance = 3000;
    public static int trackEnd = 27000;
    public static TruckSim mainSim;
    public static int truckNumber = 0;
    public static double truckPackages;
    public static double truckClock = 0.0;
    public static double finalTruckTime;
    public static double finalDroneTime;

    public static void main(String[] args) throws Exception {
        double droneClock = 0.0;
        int droneNumber = 0;
        double percentage;
        double packages;
        double dronePackages;
        int counter = 0;
        Scanner input = new Scanner(System.in);
        Scanner fileRead = new Scanner(new File("train_schedule.txt"));
        while(fileRead.hasNext()){
            trainStarts.add(fileRead.nextDouble());
            trainEnds.add((trainStarts.get(counter) + fileRead.nextDouble()));
            counter++;
        }
        for(int i = 0; i<trainStarts.size(); i++){
            crossingLines.add(new ArrayDeque<Truck>());
            eventList.add(new Events(trainStarts.get(i), ": TRAIN arrives at crossing"));
            eventList.add(new Events(trainEnds.get(i), ": TRAIN leaves crossing"));
        }
        System.out.println("How many packages are being delivered and what percent by drone?(Format: Packages dronePercent)");
        packages = input.nextInt();
        percentage = input.nextDouble();
        dronePackages = Math.ceil(packages*(percentage/100.0));
        truckPackages = packages - dronePackages;
        mainSim = new TruckSim(percentage, packages);
        while(dronePackages != 0){
            drones.add(new Drone(droneClock, droneNumber+1));
            dronePackages= dronePackages-Drone.capacity;
            drones.get(droneNumber).start();
            droneNumber++;
            droneClock = droneClock+Drone.interval;
        }
        while(truckPackages > 0 && (truckClock + (trackDistance/Truck.speed)) < trainEnds.get(0)){
            trucks.add(new Truck(truckClock, truckNumber+1));
            truckPackages = truckPackages-Truck.capacity;
            truckNumber++;
            truckClock = truckClock+Truck.interval;
        }
        trucks.get(trucks.size()-1).last = true;
        for(int i = 0; i<trucks.size();i++){
            TimeUnit.MILLISECONDS.sleep(500);
            trucks.get(i).start();
        }
        
    }
}
