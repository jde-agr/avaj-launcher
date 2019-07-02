package simulator.aircrafts;

import simulator.*;
import weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {
        String curWeather = weatherTower.getWeather(this.coordinates);
        //For testing
        // System.out.println("Weather " + curWeather);
        if (curWeather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
        }
        else if (curWeather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
        }
        else if (curWeather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
        }
        else if (curWeather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15); //-15
        }
        //For testing
        System.out.println("Weth Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
        if (this.coordinates.getHeight() <= 0) {
            // System.out.println("Tower says: Baloon#" + this.name + "(" + + this.id + ") unregistered from weather tower.");
            file.writeToFile("Tower says: Baloon#" + this.name + "(" + + this.id + ") unregistered from weather tower.\n");
            weatherTower.unregister(this);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        // System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
        file.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.\n");
        // weatherTower.getWeather(this.coordinates);
        weatherTower.register(this);
    }
    //For testing
    public void display() {
        System.out.println("Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
    }
}