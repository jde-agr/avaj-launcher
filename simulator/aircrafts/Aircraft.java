package simulator.aircrafts;

import simulator.aircrafts.*;
import weather.Coordinates;
import simulator.Logger;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    protected static Logger file = Logger.getLogger();

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }
    private long nextId() {
        idCounter += 1;
        return this.idCounter;
    }
}