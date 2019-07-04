package simulator.aircrafts;

import simulator.*;
import weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {
        String curWeather = weatherTower.getWeather(this.coordinates);
        //For testing
        // System.out.println("Weather " + curWeather);
        if (curWeather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
            file.writeToFile("JetPlane#" + this.name + "(" + + this.id + "): Perfect skies to explore today.\n");
        }
        else if (curWeather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
            file.writeToFile("JetPlane#" + this.name + "(" + + this.id + "): It's raining. Better watch out for lightings.\n");
        }
        else if (curWeather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
            file.writeToFile("JetPlane#" + this.name + "(" + + this.id + "): I see!! I see...MISTY!\n");
        }
        else if (curWeather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
            file.writeToFile("JetPlane#" + this.name + "(" + + this.id + "): OMG! Winter is coming!\n");
        }
        //For testing
        // System.out.println("Weth Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
        if (this.coordinates.getHeight() <= 0) {
            // System.out.println("Tower says: JetPlane#" + this.name + "(" + + this.id + ") unregistered from weather tower.");
            file.writeToFile("JetPlane#" + this.name + "(" + + this.id + ") landing. Longitude: " + this.coordinates.getLongitude() + "\tLatitude: " + this.coordinates.getLatitude() + "\tHeight: " + this.coordinates.getHeight() + "\n");
            file.writeToFile("Tower says: JetPlane#" + this.name + "(" + + this.id + ") unregistered from weather tower.\n");
            weatherTower.unregister(this);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        // System.out.println("Tower says: JetPlane#" + this.name + "(" + + this.id + ") registered to weather tower.");
        file.writeToFile("Tower says: JetPlane#" + this.name + "(" + + this.id + ") registered to weather tower.\n");
        weatherTower.register(this);
        if (this.coordinates.getHeight() <= 0) {
            // System.out.println("Tower says: JetPlane#" + this.name + "(" + + this.id + ") unregistered from weather tower.");
            file.writeToFile("JetPlane#" + this.name + "(" + + this.id + ") landing. Longitude: " + this.coordinates.getLongitude() + "\tLatitude: " + this.coordinates.getLatitude() + "\tHeight: " + this.coordinates.getHeight() + "\n");
            file.writeToFile("Tower says: JetPlane#" + this.name + "(" + + this.id + ") unregistered from weather tower.\n");
            weatherTower.unregister(this);
        }
    }
    //For testing
    public void display() {
        System.out.println("Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
    }
}