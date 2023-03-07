
import java.util.ArrayList;
import java.util.Arrays;

public class Word {

    //initiera variabler och Array
    private String word;
    public String randomword;
    public String guessedword;


    public String[] blanks;

    //Setter för blanks Arrayen
    public void setBlanks(String input, int index) {
        this.blanks[index] = input;
    }

    //getter för det slumpade ordet
    public String getWord() {
        return word;
    }

    //getter för att hämta det slumpade ordet, här skapas också de stjärnor som döljer de ord man gissar på.
    public void setWord(String word) {
        this.word = word;
        guessedword = "";
        blanks = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            setBlanks("*", i);
        }
    }

    //metod för att matcha gissningen mot det slumpade ordet.
    public void checkTheLetter(String word, String letter) {
        String[] LettersfromTheWord = word.split(""); // splitta ordet till en array och gör om arrayen till en lista.
        ArrayList<String> separatedLetters = new ArrayList<>(Arrays.asList(LettersfromTheWord));

        //kolla om listan innehåller gissningen
        if (separatedLetters.contains(letter)) {
            System.out.println("Den bokstaven finns i ordet!");

            int index = separatedLetters.indexOf(letter);//om den gör det, ta index på den bokstaven från det slumpade ordet,
            blanks[index] = letter; // och sätt in gissningen på rätt index i blanks

            System.out.println();
            randomword = String.join("", separatedLetters);// gör om listan till en string variable
            guessedword = String.join("", blanks); //gör samma med blanks arrayen
        } else {
            System.out.println("Den bokstaven finns inte i ordet!");
        }
    }
}
