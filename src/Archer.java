public class Archer extends Character {
    private int agility;

    public Archer(String name, int healthPoints, int level, int experience, int agility){
        super(name, healthPoints, level, experience);
        this.agility = agility;
    }

    @Override
    public void attack(Character target) {
        int damage = level * agility;
        System.out.println(name + " shoots arrows at " + target.getName() + " for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public String toString() {
        return name + " [HP: " + healthPoints + ", Level: " + level + ", XP: " + experience + "] [Agility: " + agility + "]";
    }
}
