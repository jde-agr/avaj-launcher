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
        System.out.println("Weather " + curWeather);
        if (curWeather.equals("SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
        }
        else if (curWeather.equals("RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
        }
        else if (curWeather.equals("FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
        }
        else if (curWeather.equals("SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
        }
        //For testing
        System.out.println("Weth Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Tower says: JetPlane#" + this.name + "(" + + this.id + ") unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#" + this.name + "(" + + this.id + ") registered to weather tower.");
        weatherTower.register(this);
    }
    //For testing
    public void display() {
        System.out.println("Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
    }
}