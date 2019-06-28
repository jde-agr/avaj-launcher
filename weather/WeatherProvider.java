package weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String[] weather;

    private WeatherProvider() {
        this.weatherProvider = this;
        this.weather = ["RAIN", "FOG", "SUN", "SNOW"];
    }
    public static WeatherProvider getProvider() {
        return this.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        int indx = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        return this.weather[indx];
    }
}