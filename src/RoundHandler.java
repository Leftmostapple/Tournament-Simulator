import java.util.Scanner;
public class RoundHandler {
    final String YELLOW = "\u001B[38;2;255;220;100m";
    final String RESET = "\u001B[0m";
    final String RED = "\u001B[38;5;203m";
    private final Player[] playerList;
    private final Player[] winners;
    Scanner input = new Scanner(System.in);

    public RoundHandler(Player[] playerList){
        this.playerList = playerList;
        this.winners = new Player[playerList.length/2];

    }

    public Player[] startRound(){
        int j = 0;

        for(int i = 1; i < playerList.length; i += 2){
            System.out.println(YELLOW + "Match " + (j+1) + RESET);
            Fight newFight = new Fight(playerList[i], playerList[i-1]);
            winners[j] = newFight.startFight();

            j++;

            System.out.println(RED + "Type Anything to move on" + RESET);
            input.next();
            Main.clearConsole();
            System.out.flush();
        }

        return winners;
    }
}
