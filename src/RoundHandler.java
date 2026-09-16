public class RoundHandler {
    private final Player[] playerList;
    private Player[] winners;

    public RoundHandler(Player[] playerList){
        this.playerList = playerList;
        this.winners = new Player[playerList.length/2];

    }

    public Player[] startRound(){
        int j = 0;
        for(int i = 1; i < playerList.length; i += 2){
            Fight newFight = new Fight(playerList[i], playerList[i-1]);
            winners[j] = newFight.startFight();
            j++;
        }

        return winners;
    }
}
