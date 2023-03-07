import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordlist {

    //lista för ordlistan
    ArrayList<String> wordlist = new ArrayList<>();


    //metod för att slumpa ord ur ordlistan
    public String randomword() {
        Random random = new Random();
        int index = random.nextInt(wordlist.size());
        return wordlist.get(index);
    }

    //metod för att lägga till ord i ordlistan,  i början av spelet
    //utan att spelaren ska behöva se det.
    public void addWord(String ord) {
        wordlist.add(ord);
    }

    //överlagrad-metod för att användaren ska kunna lägga till ord i spelet
    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vilket ord vill du lägga till?");
        String word = scanner.nextLine();
        word = word.toLowerCase();
        if (!wordlist.contains(word)) {
            wordlist.add(word);
            System.out.println("Ordet är tillagt");
        } else {
            System.out.println("Ordet finns redan");
        }
    }

    //metod för att ta bort ord
    public void removeWord() {
        Scanner scanner = new Scanner(System.in);
        for (String word : wordlist) {
            System.out.println(word);
        }
        System.out.println("Vilket ord vill du ta bort?");
        String word = scanner.nextLine();
        word = word.toLowerCase();
        if (wordlist.contains(word)) {
            wordlist.remove(word);
            System.out.println("Ordet är borttaget");
        } else {
            System.out.println("Ordet finns inte med i listan");
        }
    }

}
