import java.util.*;

public class RadioAlphabet {
    private Map<Character, String> natoMap;

    public RadioAlphabet(String alpha, String deli) {
        natoMap = new HashMap<Character, String>();
        String[] words = alpha.split(deli);
        
        for (int i = 0; i < words.length; i++) {
            natoMap.put(words[i].charAt(0), words[i]);
        }

    }

    public boolean converts(char c) {
        return this.natoMap.containsKey(c);
    }

    public String convert(char c) {
        if (this.converts(c)) {
            return this.natoMap.get(c);
        } else {
            return null;
        }
    }

    public String convert(String depr) {
        String dust = "";
        for (int i = 0; i < depr.length(); i++) {
            if (this.converts(depr.charAt(i))) {
               dust += this.convert(depr.charAt(i));
               dust += " ";
            }
        }
        return dust;
    }

    public void setWord(String s) {
        if (this.converts(s.charAt(0))) {
            this.removeWord(s.charAt(0));
            this.natoMap.put(s.charAt(0), s);
        }
    }

    public void removeWord(char c) {
        this.natoMap.remove(c);
    }
}
