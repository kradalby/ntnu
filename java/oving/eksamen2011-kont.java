public class Song {

    private String vowels = "aeiousAEIOUS";
    private String song;

    public Song(String song) {
        this.song = song;
    }
    
    public boolean isVowel(char c) {
        for (int i = 0; i < vowels.length(); i++) {
            if (vowels.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public String computeVerse(String originalVerse, char v) {
           String newVerse = "";
           if (isVowel(v)) {
               for (int i = 0; i < originalVerse.length(); i++) {
                   if (isVowel(originalVerse.charAt(i))) {
                       if (Character.isUpperCase(originalVerse.charAt(i)))
                           newVerse += Character.toUpperCase(v);
                       else
                           newVerse += v;
                   } else {
                       newVerse += originalVerse.charAt(i);
                   }
               }
           } else { 
           //throw AintNoVowelException;
           }
           return newVerse;
    }

    public void writeSong(String vowels) {
        for (int i = 0; i < vowels.length(); i++) {
            System.out.println(computeVerse(this.song, vowels.charAt(i)));
        }
    }

}

public class Ranking {
    private double points = 1, vekt = 1;

    public void receivePoints(int points, Person rater) {
        if (points < 1 || 5 > points) {
            throw new IllegalArgumentException("herpaderp");
        }
        double ratervekt = rater.getVekt();
        this.points += points * ratervekt;
        this.vekt += ratervekt;
    }

    public int getRating() {
        return points / vekt;
    }
}

public class Person extends Rating{

    private String name;

 
    public Person(String name) {
        this.name = name;

    }


}

public class Submission extends Rating{
    
    private String tittel;

    public Submission(String tittel) {
        this.tittel = tittel;
    }

}


