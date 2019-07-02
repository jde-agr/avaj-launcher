package simulator;

import java.util.*; //To make use of ArrayList
import simulator.aircrafts.*;
public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        //For Testing
        // System.out.println("Tower says: " + flyable + " registered to weather tower.");
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }
    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
    //For testing
    public void display() {
        for (Flyable fly : this.observers) {
            fly.display();
        }
    }
}