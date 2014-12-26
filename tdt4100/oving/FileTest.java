import java.io.*;
import java.util.*;

public class FileTest {
    private static BufferedReader buffy;

    public static void main(String[] args) {
        
        try {
            buffy = new BufferedReader(new FileReader("test.txt"));
            String herpaderp;
            while ((herpaderp = buffy.readLine()) != null) {
                System.out.println(herpaderp);
            }
            
        } catch (IOException derp) {
            System.out.println("Kukk i gulost");
        }    

        System.out.println(args[0]);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Skriv inn shit: ");
            String merp = sc.nextLine();
            if (merp != "exit") {
                System.out.println("merp");
            } else {
                break;
            }
        }

    }
}
