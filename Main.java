import java.io.*;
import java.util.*;
import simulator.*;
import simulator.aircrafts.*;

public class Main {
    private static WeatherTower weatherTower;
    // private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length == 1) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                Integer repeats = 0;
                weatherTower = new WeatherTower();
                try {
                    boolean first = true;
                    for (String line; (line = br.readLine()) != null;) {
                        if (first) {
                            repeats = Integer.parseInt(line);
                            first = false;
                        } else {
                            // System.out.println("0: " + line.split(" ")[0] + " 1: " + line.split(" ")[1] + " 2: " + line.split(" ")[2] + " 3: " + line.split(" ")[3] + " 4: " + line.split(" ")[4]);
                            Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                            // weatherTower.register(flyable);
                            flyable.registerTower(weatherTower);
                        }
                    }
                    // weatherTower.display();
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