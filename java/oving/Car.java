import java.util.*;

public class Car implements Comparable<Car> {
    private String name;
    private int cost;

    public Car(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int compareTo(Car o) {
        if (this.cost == o.getCost()) {
            return 0;
        } else if (this.cost > o.getCost()) {
            return 1;
        } else {
            return -1;
        }
    }       
}
