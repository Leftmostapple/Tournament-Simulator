//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String GREEN = "\u001B[38;2;144;238;144m";
        final String CHAMPION = "\u001B[1;4;38;2;255;215;80m";
        final String RED = "\u001B[38;5;203m";
        final String RESET = "\u001B[0m";
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

                nameAllPlayers(players);

                int round = 1;
                System.out.println(GREEN + "Round " + round + RESET + "\n----------");
                round += 1;

                System.out.println(RED + "Type Anything to move onto results" + RESET);
                input.next();
                clearConsole();
                System.out.flush();

                RoundHandler newTournament = new RoundHandler(players);
                Player[] winnersFirstRound = newTournament.startRound();

                for(int i = 0; i < winnersFirstRound.length; i++){
                    winnersFirstRound[i].enhancePlayer(winnersFirstRound[i]);
                }

                while(winnersFirstRound.length != 1) {
                    System.out.println(GREEN + "\n\nRound " + round + RESET + "\n----------");
                    round += 1;

                    RoundHandler nextRound = new RoundHandler(winnersFirstRound);
                    winnersFirstRound = nextRound.startRound();


                    if(winnersFirstRound.length != 1) {
                        for (int i = 0; i < winnersFirstRound.length; i++) {
                            winnersFirstRound[i].enhancePlayer(winnersFirstRound[i]);
                        }
                    }

                    }
                System.out.println(CHAMPION + winnersFirstRound[0].getFullName() + " is the Champion!");
                }

                gameCondition = true;
            }
        }

        public static void nameAllPlayers(Player[] playerList){
            int numPlayers = playerList.length;

            for (int plyGen = 0; plyGen < numPlayers; plyGen++) {

                playerList[plyGen] = new Player();

                System.out.println(playerList[plyGen].getFullName()
                        + "\n Health: " + playerList[plyGen].getHealth()
                        + "\n Strength: " + playerList[plyGen].getStrength()
                        + "\n Intellect: " + playerList[plyGen].getIntellect()
                        + "\n Experience: " + playerList[plyGen].getExperience() + "\n");
            }
        }

        public static void clearConsole(){
            for(int i = 0; i < 30; i++){
                System.out.println();
            }
        }
    }
