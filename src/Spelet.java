import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Spelet {


    //initiera instanser av klasser
    Ord ord = new Ord();

    Spelare spelare = new Spelare("okände spelare", 0);
    Ordlista ordlista = new Ordlista();
    Meny meny = new Meny();

    //initiera variabler och lista
    int antalGissningar = 10;

    ArrayList<String> gissadeBokstäver = new ArrayList<>();

    //metoden som driver själva spelet.
    public void startaSpelet() {
        Scanner scanner = new Scanner(System.in);
        antalGissningar = 0;
        gissadeBokstäver.clear();
        ordlista.läggTillOrd("dator");
        ordlista.läggTillOrd("ost");
        ordlista.läggTillOrd("peka");
        ordlista.läggTillOrd("blod");
        ordlista.läggTillOrd("tv");
        ordlista.läggTillOrd("ko");
        ordlista.läggTillOrd("vas");
        ordlista.läggTillOrd("keps");

        while (true) {
            meny.visaHuvudmenyn(); //skriv ut huvudmenyn
            Switchmenu(scanner);
        }

    }

    private void Switchmenu(Scanner scanner) {
        int menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                bytName();
                break;
            case 2:
                ordlista.läggTillOrd();
                break;
            case 3:
                ordlista.taBortOrd();
                break;
            case 4:
                gissa();
            case 5:
                avslutaSpelet();
                break;
            default:
                System.out.println("Det valet finns inte!");
                break;
        }
    }

    //Metod för att byta namn på spelaren
    public void bytName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vad vill du byta till?");
        String bytaTill = scanner.nextLine();
        spelare.setNamn(bytaTill);
        System.out.println("Din spelare heter nu " + bytaTill);
    }

    // metod för att gissa på ett ord.
    public void gissa() {
        Scanner scanner = new Scanner(System.in);
        ord.setOrd(ordlista.slumpaOrd()); //här hämtas det slumpade ordet.


        while (true) {
            //tvinga spelaren att byta namn om hen inte redan gjort det.
            if (spelare.getNamn().equals("okände spelare")) {
                System.out.println("borde du inte byta namn på din spelare?");
                bytName();
            }
            System.out.println("Ordet har " + ord.getOrd().length() + " bokstäver i sig");
            for (int i = 0; i < ord.blanks.length; i++) {   //skriv ut blanks
                System.out.print(ord.blanks[i]);
            }
            System.out.println();

            if (!gissadeBokstäver.isEmpty()) {                                    //ifall spelaren redan gissat på bokstäver
                System.out.println("Du har tidigare gissar på bokstäverna : "); //skrivs det ut vilka som redan gissats på
                for (int i = 0; i < gissadeBokstäver.size(); i++) {
                    System.out.print(gissadeBokstäver.get(i) + ",");
                }
                System.out.println();
            }

            System.out.println("Vilken bokstav vill du gissa på?");     //ta emot gissning och kolla om det redan gissats på.
            String gissning = scanner.nextLine();
            gissning = gissning.toLowerCase();
            if ((gissadeBokstäver.contains(gissning))) {
                System.out.println("Det har du redan gissat på");
            } else {
                ord.matchaBokstav(ord.getOrd(), gissning);          //skicka det vidare om det inte redan gissats på.
                gissadeBokstäver.add(gissning);
                antalGissningar--;

                if (antalGissningar == 0) {              //om gissningarna (10 st) tar slut innan spelaren klarar det.
                    System.out.println("-----------------------------");
                    System.out.println("Nu var dina gissningar slut");
                    playAgain();
                } else if (ord.slumpadeOrdet.equals(ord.gissadeOrdet)) {  //om spelaren klarar det
                    vinnare();
                }
            }
        }
    }

    //metod för att avsluta
    public void avslutaSpelet() {
        System.out.println("Tack för att du spelade " + spelare.getNamn());
        if(spelare.getPoäng() > 0){
            System.out.println("Du fick totalt : " + spelare.getPoäng() + "poäng");
        }
        System.exit(0);
    }

    //metod för vinnaren
    public void vinnare() {
        spelare.ökapoäng();

        System.out.println("Du vann! Grattis! Cake for Everyone!");
        playAgain();

    }

    private void playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vill du spela igen? j/n");
        String playAgain = scanner.nextLine();
        if (playAgain.equalsIgnoreCase("j")){
            startaSpelet();
        }else {
            avslutaSpelet();
        }
    }
}
