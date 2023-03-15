import java.util.Random;

public class Hero {
    String name;
    int hp;

    public Hero(String name) {
        this.name = name;
        this.hp = 100;
    }

    public String getName() {return name;}
    public int gethp() {return hp;}

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }

    public void senzuBean() { hp = 100; }

    public void attack(Hero opponent) {
        Random random = new Random();
        if (random.nextDouble(1) < 0.5)
            opponent.hp -= 10;
        else
            hp -= 10;
    }


    public void fightUntilTheDeathHelper(Hero opponent) {
        while (hp != 0 && opponent.gethp() != 0)
            attack(opponent);
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hp + "        " + opponent.getName() + ": " + opponent.gethp();
    }

    public int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] score = new int[2];
        for (int i = 0; i < n; i++) {
            String result = fightUntilTheDeath(opponent);
            int colOneIn = result.indexOf(":");
            int colTwoIn = result.indexOf(":", colOneIn + 1);
            int heroHealth = Integer.parseInt(result.substring(colOneIn + 2, colOneIn + 3));
            int opponentHealth = Integer.parseInt(result.substring(colTwoIn + 2, colTwoIn + 3));

            if (heroHealth > opponentHealth)
                score[0]++;
            else
                score[1]++;
        }
        return score;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] score = nFightsToTheDeathHelper(opponent, n);
        if (score[0] > score[1]) {
            return name + ": " + score[0] + " wins\n"
            + opponent.getName() + ": " + score[1] + " wins\n"
            + name + " wins!";
        }
        else {
            return name + ": " + score[0] + " wins\n"
            + opponent.getName() + ": " + score[1] + " wins\n" 
            + opponent.getName() + " wins!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        while (hp != 0 && opponent.gethp() != 0) {
            attack(opponent);
            System.out.println(name + ": " + hp + "\t" 
            + opponent.getName() + ": " 
            + opponent.gethp());
        }
    }

}