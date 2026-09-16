import java.util.Random;

public class Player {
    Random random = new Random();

    private final String fullName;
    private int wins;
    private int losses;
    private int strength;
    private int intellect;
    private int experience;
    private int health;

    public Player(int wins, int losses){
        NameGenerator newName = new NameGenerator();

        this.fullName = newName.getFullName();
        this.wins = wins;
        this.losses = losses;
        this.strength = random.nextInt(10) + 1;
        this.intellect = random.nextInt(10) + 1;
        this.experience = random.nextInt(10) + 1;
        this.health = random.nextInt(50, 100) + 1;
    }

    public String getFullName(){
        return fullName;
    }
    public int getHealth(){ return health; }
    public int getStrength(){
        return strength;
    }
    public int getIntellect(){
        return intellect;
    }
    public int getExperience(){ return experience; }

}
