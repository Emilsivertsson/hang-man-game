public class Spelare {

    //initiera variabler
    private String namn;
    private int poäng;

    //konstruktor
    public Spelare(String namn, int poäng) {
        this.namn = namn;
        this.poäng = poäng;
    }

    //Getters and setters
    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

}
