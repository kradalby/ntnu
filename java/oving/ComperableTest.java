import java.util.*;

public class ComperableTest {
    
    public static void main(String[] args) {
        Car volvo = new Car("volvo", 3000);
        Car bmw = new Car("bmw", 2000);
        Car vw = new Car("vw", 900000);
        Car lada = new Car("lada", 4000);
        List<Car> cars = new ArrayList<Car>();
        cars.add(volvo);
        cars.add(bmw);
        cars.add(vw);
        cars.add(lada);
        //Collections.sort(cars);

   

        Collections.sort(cars, new CarComparator());

        for (Car c: cars) {
            System.out.println(c.getName() + ": " + c.getCost());
        }
    }

}
