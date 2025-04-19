public class Warrior extends Character {
    private int defensePoints;

    public Warrior(String name, int healthPoints, int level, int experience, int defensePoints) {
        super(name, healthPoints, level, experience);
        this.defensePoints = defensePoints;
    }

    @Override
    public void attack(Character target) {
        int damage = 10 + getLevel() + (experience / 10);
        System.out.println(getName() + " slashes " + target.getName() + " with a sword for " + damage + " damage!");
        target.setHealthPoints(target.getHealthPoints() - damage);
    }

    public void judgmentSpin(Character target) {
        int damage = 20 + getLevel() * 2;
        System.out.println(getName() + " uses JUDGMENT SPIN on " + target.getName() + " for " + damage + " damage!");
        target.setHealthPoints(target.getHealthPoints() - damage);
    }

    public void defend() {
        System.out.println(getName() + " raises shield to reduce incoming damage next turn!");
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    @Override
    public String toString() {
        return super.toString() + " [Defense: " + defensePoints + "]";
    }
}

