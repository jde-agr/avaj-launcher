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