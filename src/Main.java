//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        boolean gameCondition = false;
        int numPlayers;

        while (!gameCondition) {
            System.out.println("Valid Tournament Sizes: 2, 4, 8, 16, 32, 64\n Pick a Size: ");
            numPlayers = input.nextInt();

            for (int i = 2; i < 128; i *= 2) {
                if (numPlayers == i) {
                    gameCondition = true;
                }
            }
            if (gameCondition) {
                Player[] players = new Player[numPlayers];

                for (int plyGen = 0; plyGen < numPlayers; plyGen++) {

                    players[plyGen] = new Player(0, 0);

                    System.out.println(players[plyGen].getFullName()
                            + "\n Health: " + players[plyGen].getHealth()
                            + "\n Strength: " + players[plyGen].getStrength()
                            + "\n Intellect: " + players[plyGen].getIntellect()
                            + "\n Experience: " + players[plyGen].getExperience() + "\n");
                }
                RoundHandler newTournament = new RoundHandler(players);
                Player[] winnersFirstRound = newTournament.startRound();

                while(winnersFirstRound.length != 1) {
                    RoundHandler nextRound = new RoundHandler(winnersFirstRound);
                    winnersFirstRound = nextRound.startRound();
                    }
                System.out.println(winnersFirstRound[0].getFullName() + " is the Champion!");
                }

                gameCondition = true;
            }
        }
    }
