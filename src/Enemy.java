public class Enemy extends Character{

    public Enemy(String name, int healthPoints, int level, int experience){
        super(name, healthPoints, level,experience);
    }

    @Override
    public void attack(Character target) {
        if (target != null && target.isAlive()) {
            int damage = level * experience;
            System.out.println(name + " attacks " + target.getName() + " for " + damage + " damage!");
            target.takeDamage(damage);

            if (!target.isAlive()) {
                System.out.println(target.getName() + " has fallen!");
            }
        }
    }


    @Override
    public String toString() {
        return "Enemy: " + super.toString();
    }
}
