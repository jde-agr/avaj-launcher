package simulator.aircrafts;

// import simulator.*;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type == "Baloon") {
            Flyable baloon = new Baloon(name, coordinates);
            return baloon;
        }
        if (type == "Helicopter") {
            Flyable helicopter = new Helicopter(name, coordinates);
            return helicopter;
        }
        if (type == "JetPlane") {
            Flyable jetPlane = new JetPlane(name, coordinates);
            return jetPlane;
        }
        return null;
    }
}