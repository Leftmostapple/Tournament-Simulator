import java.util.Random;
import java.util.Scanner;

public class Player {
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    final String RED = "\u001B[38;5;203m";
    final String RESET = "\u001B[0m";

    private final String fullName;
    private int strength;
    private int intellect;
    private int experience;
    private int health;


    public Player(){
        NameGenerator newName = new NameGenerator();

        this.fullName = newName.getFullName();
        this.strength = random.nextInt(10) + 1;
        this.intellect = random.nextInt(10) + 1;
        this.experience = random.nextInt(10) + 1;
        this.health = random.nextInt(10) + 1;
    }

    public void enhancePlayer(Player playerToEnhance){
        int oldStrength = this.strength;
        int oldIntellect = this.intellect;
        int oldExperience = this.experience;
        int oldHealth = this.health;
        this.strength += random.nextInt(10);
        this.intellect += random.nextInt(10);
        this.experience += random.nextInt (10);
        this.health += random.nextInt(10);

        System.out.println("\n-----------\n" + playerToEnhance.getFullName() + "\nStrength: " + oldStrength + " -> " + this.strength +
                           "\nIntellect: " + oldIntellect + " -> " + this.intellect +
                           "\nExperience: " + oldExperience + " -> " + this.experience +
                           "\nHealth: " + oldHealth + " -> " + this.health);

        System.out.println(RED + "Type Anything to move on" + RESET);
        input.next();
        Main.clearConsole();
        System.out.flush();
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
