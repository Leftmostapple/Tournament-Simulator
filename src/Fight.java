import java.util.Random;
import java.util.Scanner;

public class Fight {
    final String RED = "\u001B[31m";
    final String ORANGE = "\u001B[38;2;255;165;0m";
    final String GREEN = "\u001B[38;2;144;238;144m";
    final String RESET = "\u001B[0m";
    final String SOFT_RED = "\u001B[38;5;203m";
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    Player p1;
    Player p2;

    public Fight(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Player startFight() {
        System.out.println(ORANGE + p1.getFullName() + RED + " VS " + ORANGE + p2.getFullName() + RESET);

        int[] playerProbabilities = {50, 50};
        playerProbabilities = calculateProbability(playerProbabilities, p1.getHealth(), p2.getHealth(), 1);
        playerProbabilities = calculateProbability(playerProbabilities, p1.getExperience(), p2.getExperience(), 2);
        playerProbabilities = calculateProbability(playerProbabilities, p1.getIntellect(), p2.getIntellect(), 1);
        playerProbabilities = calculateProbability(playerProbabilities, p1.getStrength(), p2.getStrength(), 3);

        int total = playerProbabilities[0] + playerProbabilities[1];
        double p1Chance = ((double) playerProbabilities[0] / total) * 100;
        double p2Chance = ((double) playerProbabilities[1] / total) * 100;

        int roller = random.nextInt(100);

        System.out.println(p1.getFullName() + ": " + (int)p1Chance + "%");
        System.out.println(p2.getFullName() + ": " + (int)p2Chance + "%");

        System.out.println(SOFT_RED + "Type Anything to move on" + RESET);
        input.next();
        Main.clearConsole();
        System.out.flush();

        if(roller < p1Chance){
            System.out.println(GREEN + p1.getFullName() + " Wins!" + RESET);
            return p1;
        } else {
            System.out.println(GREEN + p2.getFullName() + " Wins!" + RESET);
            return p2;
        }
    }

    public int[] calculateProbability(int[] playerProbability, int p1Attribute, int p2Attribute, int multiplier) {

        if (p1Attribute > p2Attribute + 9) {
            playerProbability[0] += 4 * multiplier;
            playerProbability[1] -= 4 * multiplier;
        } else if (p1Attribute > p2Attribute + 5) {
            playerProbability[0] += 2 * multiplier;
            playerProbability[1] -= 2 * multiplier;
        } else if (p1Attribute > p2Attribute) {
            playerProbability[0] += multiplier;
            playerProbability[1] -= multiplier;
        } else if (p2Attribute > p1Attribute + 9) {
            playerProbability[1] += 4 * multiplier;
            playerProbability[0] -= 4 * multiplier;
        } else if (p2Attribute > p1Attribute + 5) {
            playerProbability[1] += 2 * multiplier;
            playerProbability[0] -= 2 * multiplier;
        } else if(p2Attribute > p1Attribute){
            playerProbability[1] += multiplier;
            playerProbability[0] -= multiplier;
        }

        return playerProbability;
    }
}
