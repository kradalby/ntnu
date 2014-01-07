import java.util.*;
import java.io.*;

public class FilewriteTest {
    

    public static void main(String[] args) {
      try {
            BufferedWriter buffy;
            buffy = new BufferedWriter(new FileWriter("test2.txt"));
            String derp = "Testytesty";
            String derp2 = "Buffy the vampire slayer";
            buffy.write(derp);
            buffy.newLine();
            buffy.write(derp2);
            buffy.close();
        } catch (IOException derp) {
            System.out.println(derp);
        }
    }
}
