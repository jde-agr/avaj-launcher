package simulator.aircrafts;

import simulator.*;
import weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {
        String curWeather = weatherTower.getWeather(this.coordinates);
        //For testing
        // System.out.println("Weather " + curWeather);
        if (curWeather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
            file.writeToFile("Helicopter#" + this.name + "(" + + this.id + "): This is hot.\n");
        }
        else if (curWeather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
            file.writeToFile("Helicopter#" + this.name + "(" + + this.id + "): Why do I suddenly feel like a portable sprinkler?\n");
        }
        else if (curWeather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
            file.writeToFile("Helicopter#" + this.name + "(" + + this.id + "): I see!! I see..let me get back to you once I can actually see something.\n");
        }
        else if (curWeather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
            file.writeToFile("Helicopter#" + this.name + "(" + + this.id + "): My rotor is going to freeze!.\n");
        }
        //For testing
        System.out.println("Weth Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
        if (this.coordinates.getHeight() <= 0) {
            // System.out.println("Tower says: Helicopter#" + this.name + "(" + + this.id + ") unregistered from weather tower.");
            file.writeToFile("Tower says: Helicopter#" + this.name + "(" + + this.id + ") landing.\n");
            file.writeToFile("Tower says: Helicopter#" + this.name + "(" + + this.id + ") unregistered from weather tower.\n");
            weatherTower.unregister(this);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        // System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
        file.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.\n");
        weatherTower.register(this);
    }
    //For testing
    public void display() {
        System.out.println("Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
    }
}