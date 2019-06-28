package simulator.aircrafts;

import simulator.aircrafts.*;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    private long nextId() {
        return -1;
    }
}