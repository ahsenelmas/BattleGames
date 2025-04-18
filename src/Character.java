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

    public boolean isAlive(){
        return healthPoints > 0;
    }

    public String getName(){
        return name;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public void takeDamage(int damage){
        healthPoints -= damage;
    }

    public void gainExperience(int experience){
        this.experience += xp;
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