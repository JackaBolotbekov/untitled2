package kg.geektech.game.players;

import kg.geektech.game.general.RPG_GAME;

public class Warior extends Hero {
    public Warior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            int coeff = RPG_GAME.random.nextInt(4) + 2; // 2,3,4,5
            boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
            System.out.println("Критический удар ВОИНА по БОССУ " + this.getDamage() * coeff);
        }
    }
}