package weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
        // this.weatherProvider = this;
        // this.weather = ["RAIN", "FOG", "SUN", "SNOW"];
    }
    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        int indx = Math.abs((coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4);
        return WeatherProvider.weather[indx];
    }
}