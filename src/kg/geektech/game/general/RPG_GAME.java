package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_GAME {

    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1500, 50);

        Warior warrior = new Warior(270, 20);
        Medic doc = new Medic(230, 5, 15);
        Mag magic = new Mag(260, 15);
        Berserk berserk = new Berserk(250, 10);
        Medic assistant = new Medic(280, 10, 5);
        Thor thor=new Thor(200,25);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant,thor};

        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);

        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("HEROES WIN!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss win");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_________________" + "\n");
        System.out.println("Boss HP: " + boss.getHealth() + "; DM (" + boss.getDamage() + ")");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() +
                    " HP: " + heroes[i].getHealth() + "; DM (" + heroes[i].getDamage() + ")");
        }

        System.out.println("\n" + "_________________");
    }
}