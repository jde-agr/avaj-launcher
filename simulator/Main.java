package simulator;

import java.io.*;
import java.util.*;
import simulator.*;
import simulator.aircrafts.*;
import weather.WeatherProvider;

public class Main {
    private static WeatherTower weatherTower;
    private static Logger file = Logger.getLogger();
    // private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if (args.length == 1) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                Integer repeats = 0;
                weatherTower = new WeatherTower();
                WeatherProvider weatherProvider = WeatherProvider.getProvider();
                Logger file = Logger.getLogger();
                try {
                    boolean first = true;
                    for (String line; (line = br.readLine()) != null;) {
                        if (first) {
                            repeats = Integer.parseInt(line);
                            first = false;
                        } else {
                            // System.out.println("0: " + line.split(" ")[0] + " 1: " + line.split(" ")[1] + " 2: " + line.split(" ")[2] + " 3: " + line.split(" ")[3] + " 4: " + line.split(" ")[4]);
                            try {
                                Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                                flyable.registerTower(weatherTower);
                            }
                            catch (Exception ex) {
                                new CustomException("Invalid Coordinates. Cannot create new " + line.split(" ")[0]);
                                // System.out.println(ex.toString());
                            }
                        }
                    }
                    // repeats = 2;
                    while (repeats > 0) {
                        file.writeToFile("\n=====NEW WEATHER=====\n");
                        weatherTower.changeWeather();
                        repeats--;
                    }
                    file.closeFile();
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