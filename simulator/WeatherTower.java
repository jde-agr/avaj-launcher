package simulator;

import weather.*;

public class WeatherTower {
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