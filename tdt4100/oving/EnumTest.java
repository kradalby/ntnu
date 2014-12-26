import java.util.*;

public class EnumTest {

    public enum Coins {
    
        KRONE(1), HULL(5), KIRKE(10), VIKING(20);
        private int value;

        private Coins(int value) {
            this.value = value;
        }

        public String toString() {
            switch (this) {
                case KRONE:
                    System.out.println(value); break;
                case HULL:
                    System.out.println(value); break;
                case KIRKE:
                    System.out.println(value); break;
                case VIKING:
                    System.out.println(value); break;
            }
        return super.toString();
        }
    }
    

    public static void main(String args[]){ 
    
        //Coins mynt = new Coins();

        System.out.println(Coins.HULL.toString());
    
    }

}
