package kg.geektech.game.players;

import kg.geektech.game.general.RPG_GAME;

    public class Berserk extends Hero {
        public Berserk(int health, int damage) {

            super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        }

        @Override
        public void applySuperPower(Boss boss, Hero[] heroes) {
            int saveDamageAndRevert = RPG_GAME.random.nextInt(50) + 1;
            this.setHealth(this.getHealth() + saveDamageAndRevert);
            boss.setHealth(boss.getHealth() - saveDamageAndRevert);
            System.out.println("Берсерк поглотил: (" + saveDamageAndRevert + ") урона");


        }
    }

