public class Main {
    public static void main(String[] args) {
        //initiera spelet, spelaren och ordlistan
        Player player = new Player("okände spelare",0);
        Wordlist wordlist = new Wordlist();
        Game game = new Game();
        // kalla på menyn
        game.startGame();


    }
}