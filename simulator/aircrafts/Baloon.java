package simulator.aircrafts;

public class Baloon extends Aircraft {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {}
    public void registerTower(WeatherTower weatherTower) {}
}