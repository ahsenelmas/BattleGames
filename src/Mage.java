public class Mage extends Character implements SpellCaster {
    private int manaPoints;

    public Mage(String name, int healthPoints, int level, int experience, int manaPoints){
        super(name, healthPoints, level, experience);
        this.manaPoints = manaPoints;
    }

    @Override
    public void attack(Character target) {
        int damage = level * 10;
        System.out.println(name + " attacks " + target.getName() + " with a magical strike for " + damage + " damage!");
        target.takeDamage(damage);
    }

    @Override
    public void castSpell(Character target) {
        if (manaPoints >= 20) {
            int spellDamage = level * 15;
            System.out.println(name + " casts a powerful spell on " + target.getName() + " for " + spellDamage + " damage!");
            target.takeDamage(spellDamage);
            manaPoints -= 20;
        } else {
            System.out.println(name + " tries to cast a spell but doesn't have enough mana!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Mana: " + manaPoints + "]";
    }
}
