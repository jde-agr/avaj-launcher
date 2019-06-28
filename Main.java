import java.io.*;
import java.util.*;
import simulator.*;
import simulator.aircrafts.*;

public class Main {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length == 1) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                Integer repeats = 0;
                try {
                    boolean first = true;
                    for (String line; (line = br.readLine()) != null;) {
                        if (first) {
                            repeats = Integer.parseInt(line);
                            first = false;
                        } 
                        // System.out.println(line);
                        Flyable flyable = AircraftFactory.newAircraft("Baloon", "B1", 2, 3, 20);
                        Flyable flyable2 = AircraftFactory.newAircraft("JetPlane", "J1", 23, 44, 32);
                        Flyable flyable3 = AircraftFactory.newAircraft("Helicopter", "H4", 223, 23, 54);
                    }
                }
                catch (IOException e) {
                    System.out.println(e);
                }
            }
            catch (FileNotFoundException e) {
                 System.out.println(e);
            }
        } else {
            System.out.println("Must have one argument");
        }
    }
}