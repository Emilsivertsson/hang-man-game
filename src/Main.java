public class Main {
    public static void main(String[] args) {
        //initiera spelet, spelaren och ordlistan
        Spelare spelare = new Spelare("player",0);
        Ordlista ordlista = new Ordlista();
        Spelet spelet = new Spelet();
        // kalla på menyn
        spelet.startaSpelet();


    }
}