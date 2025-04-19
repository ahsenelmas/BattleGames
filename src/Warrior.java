public class Warrior extends Character{
    private int defensePoints;

    public Warrior(String name, int healthPoints, int level, int experience, int defensePoints){
        super(name, healthPoints, level, experience);
        this.defensePoints = defensePoints;
    }

    @Override
    public void attack(Character target) {
        int baseDamage = level * 12;
        System.out.println(name + " slashes " + target.getName() + " with a sword for " + baseDamage + " damage!");
        target.takeDamage(baseDamage);
    }

    public void defend() {
        System.out.println(name + " defends, gaining +" + defensePoints + " HP!");
        this.healthPoints += defensePoints;
    }

    @Override
    public String toString() {
        return super.toString() + " [Defense: " + defensePoints + "]";
    }
}
