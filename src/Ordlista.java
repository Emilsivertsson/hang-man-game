import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ordlista {

    ArrayList<String> ordlista = new ArrayList<>();


    public String slumpaOrd() {
        Random random = new Random();
        int index = random.nextInt(ordlista.size());
        return ordlista.get(index);
    }

    public void läggTillOrd(String ord) {
        ordlista.add(ord);
    }

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
