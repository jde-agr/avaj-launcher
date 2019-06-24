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
        int indx = (coordinates.longitude + coordinates.latitude + coordinates.height) % 4;
        return this.weather[indx];
    }
}