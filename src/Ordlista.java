import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ordlista {

    //lista för ordlistan
    ArrayList<String> ordlista = new ArrayList<>();


    //metod för att slumpa ord ur ordlistan
    public String slumpaOrd() {
        Random random = new Random();
        int index = random.nextInt(ordlista.size());
        return ordlista.get(index);
    }

    //metod för att lägga till ord i ordlistan,  i början av spelet
    //utan att spelaren ska behöva se det.
    public void läggTillOrd(String ord) {
        ordlista.add(ord);
    }

    //överlagrad-metod för att användaren ska kunna lägga till ord i spelet
    public void läggTillOrd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vilket ord vill du lägga till?");
        String ord = scanner.nextLine();
        ord = ord.toLowerCase();
        if (!ordlista.contains(ord)) {
            ordlista.add(ord);
            System.out.println("Ordet är tillagt");
        } else {
            System.out.println("Ordet finns redan");
        }
    }
    //metod för att ta bort ord
    public void taBortOrd() {
        Scanner scanner = new Scanner(System.in);
        for (String ord : ordlista) {
            System.out.println(ord);
        }
        System.out.println("Vilket ord vill du ta bort?");
        String ord = scanner.nextLine();
        ord = ord.toLowerCase();
        if (ordlista.contains(ord)) {
            ordlista.remove(ord);
            System.out.println("Ordet är borttaget");
        } else {
            System.out.println("Ordet finns inte med i listan");
        }
    }

}
