import java.util.*;

public class Memory {
    
    List<String> herpaderp;
    Random rand = new Random(1337);

    public Memory(){
        this.herpaderp = new ArrayList<String>();
    }

    public int generateNumber() {
        return rand.nextInt(10);
    }

    public void addNumber() {
        this.herpaderp.add(generateNumber() + "");
    }

    public void printNumber() {
        System.out.println("Tall " + this.herpaderp.size() + ": " + this.herpaderp.get(this.herpaderp.size() - 1));
    }
    
    public boolean checkInput(String derp) {
        for (int i = 0; i < derp.length(); i++)
            if (derp.charAt(i) == this.herpaderp.get(i).charAt(0))
                return true;
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Memory game = new Memory();
        boolean running = true;

        while (running) {
            game.addNumber();
            game.printNumber();
            String derp = s.nextLine();
            if (!game.checkInput(derp)) {
                running = false;
                System.out.println("You fail succkkkah!");
            } else {
                System.out.println("Riktig!");
            }

        }
        

    }

}
