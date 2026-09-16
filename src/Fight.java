public class Fight {
    Player p1;
    Player p2;

    public Fight(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Player startFight(){
        double p1WinProbability = 0;
        double p2WinProbability = 0;
        System.out.println(p1.getFullName() + " VS " + p2.getFullName());

        p1WinProbability = p1.getHealth() + p1.getExperience() +
                p1.getIntellect() + (double) p1.getStrength() / 100;
        p2WinProbability = p2.getHealth() + p2.getExperience() +
                p2.getIntellect() + (double) p2.getStrength() / 100;
        if(p1WinProbability > p2WinProbability){
            System.out.println(p1.getFullName() + " Wins!");
            return p1;
        } else {
            System.out.println(p2.getFullName() + " Wins!");
            return p2;
        }
    }
}
