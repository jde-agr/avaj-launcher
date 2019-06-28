package simulator.aircrafts;

// import simulator.*;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equals("Baloon")) {
            Flyable baloon = new Baloon(name, coordinates);
            //For testing
            // baloon.display();
            return baloon;
        }
        if (type.equals("Helicopter")) {
            Flyable helicopter = new Helicopter(name, coordinates);
            //For testing
            // helicopter.display();
            return helicopter;
        }
        if (type.equals("JetPlane")) {
            Flyable jetPlane = new JetPlane(name, coordinates);
            //For testing
            // jetPlane.display();
            return jetPlane;
        }
        return null;
    }
}