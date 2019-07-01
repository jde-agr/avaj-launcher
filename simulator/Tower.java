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
        System.out.println("UNREG");
        System.out.println(observers.remove(flyable));
    }
    protected void conditionsChanged() {}
    //For testing
    public void display() {
        for (Flyable fly : this.observers) {
            fly.display();
        }
    }
}