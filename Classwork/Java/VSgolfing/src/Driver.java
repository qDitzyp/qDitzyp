import java.util.ArrayList;
public class Driver {
    public static void main(String[] args) throws Exception {
        Golfer g1 = new Golfer("Jared", "Smith", -17, 18);
        Golfer g2 = new Golfer("Derek", "Smith", 2, 9);
        Golfer g3 = new Golfer("Jackie", "Trunk", -17, 18);
        Golfer g4 = new Golfer("Jackie", "Smith", -17, 18);
        Golfer g5 = new Golfer("James", "Trust", 2, 9);
        Golfer g6 = new Golfer("Jeremy", "Fisher", 2, 18);
        ArrayList<Golfer> golfers = new ArrayList<>();
        golfers.add(g1);
        golfers.add(g2);
        golfers.add(g3);
        golfers.add(g4);
        golfers.add(g5);
        golfers.add(g6);
        System.out.println(golfers);
        golfers.sort(null);
        System.out.println(golfers);
    }
}
