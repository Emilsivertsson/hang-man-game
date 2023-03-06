public class Player {

    //initiera variabler
    private String name;
    int points;


    //konstruktor
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void incresePoints() {
        points++;
    }

}
