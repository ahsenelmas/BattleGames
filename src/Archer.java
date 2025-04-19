public class Archer extends Character {
    private int arrows;

    public Archer(String name, int healthPoints, int level, int experience, int arrows) {
        super(name, healthPoints, level, experience);
        this.arrows = arrows;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " shoots an arrow at " + target.getName() + " for " + (10 + getLevel()) + " damage!");
        target.setHealthPoints(target.getHealthPoints() - (10 + getLevel()));
        arrows--;
    }

    public void powerShot(Character target) {
        if (arrows >= 2) {
            System.out.println(getName() + " uses Power Shot on " + target.getName() + " for " + (20 + getLevel() * 2) + " damage!");
            target.setHealthPoints(target.getHealthPoints() - (20 + getLevel() * 2));
            arrows -= 2;
        } else {
            System.out.println("Not enough arrows for Power Shot!");
        }
    }

    public void dodge() {
        System.out.println(getName() + " tries to dodge the next attack!");
    }

    public int getArrows() {
        return arrows;
    }

    @Override
    public String toString() {
        return super.toString() + " [Arrows: " + arrows + "]";
    }
}
