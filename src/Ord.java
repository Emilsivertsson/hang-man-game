
import java.util.ArrayList;
import java.util.Arrays;

public class Ord {

    //initiera variabler och Array
    private String ord;
    public String slumpadeOrdet;
    public String gissadeOrdet;


    public String[] blanks;

    //Setter för blanks Arrayen
    public void setBlanks(String input, int index) {
        this.blanks[index] = input;
    }

    //getter för det slumpade ordet
    public String getOrd() {
        return ord;
    }

    //getter för att hämta det slumpade ordet, här skapas också de stjärnor som döljer de ord man gissar på.
    public void setOrd(String ord) {
        this.ord = ord;
        gissadeOrdet = "";
        blanks = new String[ord.length()];
        for (int i = 0; i < ord.length(); i++) {
            setBlanks("*", i);
        }
    }

    //metod för att matcha gissningen mot det slumpade ordet.
    public void matchaBokstav(String ord, String bokstav) {
        String[] bokstäverFrånOrd = ord.split(""); // splitta ordet till en array och gör om arrayen till en lista.
        ArrayList<String> separeradeBokstäver = new ArrayList<String>(Arrays.asList(bokstäverFrånOrd));

        //kolla om listan innehåller gissningen
        if (separeradeBokstäver.contains(bokstav)) {
            System.out.println("Den bokstaven finns i ordet!");

            int index = separeradeBokstäver.indexOf(bokstav);//om den gör det, ta index på den bokstaven från det slumpade ordet,
            blanks[index] = bokstav; // och sätt in gissningen på rätt index i blanks

            System.out.println();
            slumpadeOrdet = String.join("", separeradeBokstäver);// gör om listan till en string variable
            gissadeOrdet = String.join("", blanks); //gör samma med blanks arrayen

        } else {
            System.out.println("Den bokstaven finns inte i ordet!");
        }
    }
}
