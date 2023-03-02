import java.util.ArrayList;
import java.util.Scanner;

public class Spelet {



    Ord ord = new Ord();

    Spelare spelare = new Spelare("Player",0);
    Ordlista ordlista = new Ordlista();
    Meny meny = new Meny();

    int antalGissningar =10;

    ArrayList <String> gissadeBokstäver= new ArrayList<>();

    public void startaSpelet(){
        Scanner scanner = new Scanner(System.in);
        ordlista.läggTillOrd("dator");
        ordlista.läggTillOrd("ost");
        ordlista.läggTillOrd("peka");
        ordlista.läggTillOrd("blod");
        ordlista.läggTillOrd("tv");
        ordlista.läggTillOrd("flaska");
        ordlista.läggTillOrd("vas");
        ordlista.läggTillOrd("keps");

        while(true){
            meny.visaHuvudmenyn();
            int menuChoice = scanner.nextInt();
            switch (menuChoice){
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
            }
        }

    }

    public void bytName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vad vill du byta till?");
        String bytaTill = scanner.nextLine();
        spelare.setNamn(bytaTill);
        System.out.println("Din spelare heter nu " + bytaTill);
    }

    public void gissa(){
        Scanner scanner = new Scanner(System.in);
        ord.setOrd(ordlista.slumpaOrd());

        while(true){
            System.out.println("Ordet har " + ord.getOrd().length() + " bokstäver i sig");
            for (int i = 0; i < ord.blanks.length; i++) {
                System.out.print(ord.blanks[i]);
            }
            System.out.println();
            if(!gissadeBokstäver.isEmpty()){
                System.out.println("Du har tidigare gissar på bokstäverna : ");
                for (int i = 0; i <gissadeBokstäver.size() ; i++) {
                    System.out.print(gissadeBokstäver.get(i) +",");

                }
                System.out.println();
            }

            System.out.println("Vilken bokstav vill du gissa på?");
            String gissning = scanner.nextLine();
            if ((gissadeBokstäver.contains(gissning))){
                System.out.println("Det har du redan gissat på");
            }else {

                ord.matchaBokstav(ord.getOrd(), gissning);
                gissadeBokstäver.add(gissning);
                antalGissningar --;

                if (antalGissningar == 0){
                    System.out.println("-----------------------------");
                    System.out.println("Nu var dina gissningar slut");
                    avslutaSpelet();
                }
                if (ord.slumpadeOrdet.equals(ord.gissadeOrdet)){
                   vinnare();
                }
            }
        }
    }

    public void avslutaSpelet(){
        System.out.println("Tack för att du spelade " +spelare.getNamn());
        System.exit(0);
    }

    public void vinnare(){
        System.out.println("Du vann! Grattis! Cake for Everyone!");
        avslutaSpelet();

    }
}
