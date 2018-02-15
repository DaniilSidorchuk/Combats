package game;

public class Player {

    private String name;
    private int health = 100;

    Player (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int injury){
        if (injury >= health){
            health = 0;
        } else health-=injury;
    }

}
