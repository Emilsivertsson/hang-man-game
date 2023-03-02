
import java.util.ArrayList;
import java.util.Arrays;

public class Ord {

    private String ord;
    String slumpadeOrdet;
    String gissadeOrdet;


    String[] blanks;

    public void setBlanks(String input, int index) {
        this.blanks[index] = input;
    }


    public String getOrd() {
        return ord;
    }

    public void setOrd(String ord) {
        this.ord = ord;
        blanks = new String[ord.length()];
        for (int i = 0; i < ord.length(); i++) {
            setBlanks("*", i);
        }
    }

    public void matchaBokstav(String ord, String bokstav) {
        String[] bokstäverFrånOrd = ord.split("");
        ArrayList<String> separeradeBokstäver = new ArrayList<String>(Arrays.asList(bokstäverFrånOrd));


        if (separeradeBokstäver.contains(bokstav)) {
            System.out.println("Den bokstaven finns i ordet!");
            int index = separeradeBokstäver.indexOf(bokstav);
            blanks[index] = bokstav;
            System.out.println();
            slumpadeOrdet = String.join("", separeradeBokstäver);
            gissadeOrdet = String.join("", blanks);

        } else {
            System.out.println("Den bokstaven finns inte i ordet!");
        }
    }
}
