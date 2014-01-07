import java.util.*;

public class CarComparator implements Comparator<Car> {
    
    public int compare(Car a, Car b) {
        return a.getCost() - b.getCost();
    }

}
