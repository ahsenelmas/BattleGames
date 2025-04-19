public abstract class Character{
    protected String name;
    protected int healthPoints;
    protected int level;
    protected int experience;

    public Character(String name, int healthPoints, int level, int experience){
        this.name = name;
        this.healthPoints = healthPoints;
        this.level = level;
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void levelUp(){
        level++;
        experience = 0;
        healthPoints += 20;
        System.out.println(name + " has leveled up to level " + level + "!");
    }

    public boolean isAlive(){
        return healthPoints > 0;
    }

    public String getName(){
        return name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getLevel(){
        return level;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public void takeDamage(int damage){
        healthPoints -= damage;
    }

    public void gainExperience(int experience){
        this.experience += experience;
        if (experience >= 100){
            level++;
            experience -= 100;
            System.out.println("Level Up!");
        }
    }

    public abstract void attack(Character target);

    @Override
    public String toString() {
        return name + " [HP: " + healthPoints + ", Level: " + level + ", XP: " + experience + "]";
    }

}