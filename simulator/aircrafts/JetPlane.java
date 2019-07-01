package simulator.aircrafts;

import simulator.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {}
    public void registerTower(WeatherTower weatherTower) {
        System.out.print("Tower says: JetPlane#" + this.name + "(");
        weatherTower.register(this);
    }
    //For testing
    public void display() {
        System.out.println("Name: " + this.name + "\tLong: " + this.coordinates.getLongitude() + "\tLati: " + this.coordinates.getLatitude() + "\tHeig: " + this.coordinates.getHeight());
    }
}