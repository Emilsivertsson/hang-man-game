import java.util.ArrayList;
import java.util.Scanner;

public class Game {


    //initiera instanser av klasser
    Word ord = new Word();

    Player player = new Player("okände spelare", 0);
    Wordlist wordlist = new Wordlist();
    Menu menu = new Menu();

    //initiera variabler och lista
    int nrOfGuesses = 10;

    ArrayList<String> guessedLetters = new ArrayList<>();

    //metoden som driver själva spelet.
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        nrOfGuesses = 0;
        guessedLetters.clear();
        wordlist.addWord("dator");
        wordlist.addWord("ost");
        wordlist.addWord("peka");
        wordlist.addWord("blod");
        wordlist.addWord("tv");
        wordlist.addWord("ko");
        wordlist.addWord("vas");
        wordlist.addWord("keps");

        while (true) {
            menu.showMainmenu(); //skriv ut huvudmenyn
            Switchmenu(scanner);
        }

    }

    private void Switchmenu(Scanner scanner) {
        int menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                changeName();
                break;
            case 2:
                wordlist.addWord();
                break;
            case 3:
                wordlist.removeWord();
                break;
            case 4:
                guess();
            case 5:
                quitGame();
                break;
            default:
                System.out.println("Det valet finns inte!");
                break;
        }
    }

    //Metod för att byta namn på spelaren
    public void changeName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vad vill du byta till?");
        String changeTo = scanner.nextLine();
        player.setName(changeTo);
        System.out.println("Din spelare heter nu " + changeTo);
    }

    // metod för att gissa på ett ord.
    public void guess() {
        Scanner scanner = new Scanner(System.in);
        ord.setWord(wordlist.randomword()); //här hämtas det slumpade ordet.


        while (true) {
            //tvinga spelaren att byta namn om hen inte redan gjort det.
            if (player.getName().equals("okände spelare")) {
                System.out.println("borde du inte byta namn på din spelare?");
                changeName();
            }
            System.out.println("Ordet har " + ord.getWord().length() + " bokstäver i sig");
            for (int i = 0; i < ord.blanks.length; i++) {   //skriv ut blanks
                System.out.print(ord.blanks[i]);
            }
            System.out.println();

            if (!guessedLetters.isEmpty()) {                                    //ifall spelaren redan gissat på bokstäver
                System.out.println("Du har tidigare gissar på bokstäverna : "); //skrivs det ut vilka som redan gissats på
                for (int i = 0; i < guessedLetters.size(); i++) {
                    System.out.print(guessedLetters.get(i) + ",");
                }
                System.out.println();
            }

            System.out.println("Vilken bokstav vill du gissa på?");     //ta emot gissning och kolla om det redan gissats på.
            String guess = scanner.nextLine();
            guess = guess.toLowerCase();
            if ((guessedLetters.contains(guess))) {
                System.out.println("Det har du redan gissat på");
            } else {
                ord.checkTheLetter(ord.getWord(), guess);          //skicka det vidare om det inte redan gissats på.
                guessedLetters.add(guess);
                nrOfGuesses--;

                if (nrOfGuesses == 0) {              //om gissningarna (10 st) tar slut innan spelaren klarar det.
                    System.out.println("-----------------------------");
                    System.out.println("Nu var dina gissningar slut");
                    playAgain();
                } else if (ord.randomword.equals(ord.guessedword)) {  //om spelaren klarar det
                    winner();
                }
            }
        }
    }

    //metod för att avsluta
    public void quitGame() {
        System.out.println("Tack för att du spelade " + player.getName());
        if (player.getPoints() > 0) {
            System.out.println("Du fick totalt : " + player.getPoints() + "poäng");
        }
        System.exit(0);
    }

    //metod för vinnaren
    public void winner() {
        player.incresePoints();
        System.out.println("Ordet var " +ord.randomword);
        System.out.println("Du vann! Grattis! Cake for Everyone!");
        playAgain();

    }

    private void playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vill du spela igen? j/n");
        String playAgain = scanner.nextLine();
        if (playAgain.equalsIgnoreCase("j")) {
            startGame();
        } else {
            quitGame();
        }
    }
}
