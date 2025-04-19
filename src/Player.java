public class Player {
    private String username;
    private Character selectedHero;

    public Player(String username) {
        this.username = username;
    }

    public void selectHero(Character hero) {
        this.selectedHero = hero;
        System.out.println("You have selected " + hero.getName() + "!");
    }

    public Character getSelectedHero() {
        return selectedHero;
    }

    public String getUsername() {
        return username;
    }

    public void gameOver() {
        System.out.println("💀 Game Over, " + username + "! Your hero has fallen.");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Player: " + username + ", Hero: " + (selectedHero != null ? selectedHero.getName() : "None");
    }
}
