package simulator;

import simulator.aircrafts.*;
import weather.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        int indx = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        if (indx == 0) {
            return "RAIN";
        }
        else if (indx == 1) {
            return "FOG";
        }
        else if (indx == 2) {
            return "SUN";
        }
        else if (indx == 3) {
            return "SNOW";
        }
        else
            return "";
    }
    void changeWeather() {}
}