import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Main{
    static class Planet {
        private String name = "";
        public double massKg = 0.0;

        public Planet(String name, double massKg) {
            this.massKg = massKg;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public static void main(String args[]) {
        HashMap<Main.Planet, Double> distances = new HashMap<Main.Planet, Double>();
        distances.put(new Main.Planet("Mercury", 3.301e23),
                0.307);
        distances.put(new Main.Planet("Venus",
                4.867e24),
                0.307);
        distances.put(new Main.Planet("Earth",
                5.972e24),
                0.307);
    }
}


