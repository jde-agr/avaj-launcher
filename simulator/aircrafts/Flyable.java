package simulator.aircrafts;

import simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    //For testing
    public void display();
}