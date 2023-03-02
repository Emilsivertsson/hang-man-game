public class Spelare {

    private String namn;
    private int poäng;

    public Spelare(String namn, int poäng) {
        this.namn = namn;
        this.poäng = poäng;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getPoäng() {
        return poäng;
    }

    public void ökaPoäng() {
        poäng++;
    }

    public void resetPoäng() {
        poäng = 0;
    }
}
