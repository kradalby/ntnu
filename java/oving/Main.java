public class Main {


    public static void main(String[] args) {
        RadioAlphabet test = new RadioAlphabet("alfa beta kristoffer derp", " ");
        System.out.print(test.convert("abkd"));
        test.setWord("alphabet");
        System.out.print(test.convert("abkd"));
    }

}
