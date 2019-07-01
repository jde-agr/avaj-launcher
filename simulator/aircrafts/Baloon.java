package simulator.aircrafts;

import simulator.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {}
    public void registerTower(WeatherTower weatherTower) {
        System.out.print("Tower says: Baloon#" + this.name + "(");
        weatherTower.register(this);
    }
    //For testing
    public void display() {
        System.out.println("Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
    }
}