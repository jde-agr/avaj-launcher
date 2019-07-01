package simulator.aircrafts;

import simulator.aircrafts.*;
import weather.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        nextId();
    }
    private long nextId() {
        idCounter += 1;
        // System.out.println("ID: " + idCounter);
        // System.out.println("Tower says: Baloon#" + this.name + "(" + this.idCounter + ") registered to weather tower.");
        return this.idCounter;
    }
}