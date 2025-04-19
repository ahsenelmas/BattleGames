import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RiotAdventureApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RiotDatabase database = new RiotDatabase();

        System.out.println("=== Welcome to League of Heroes Adventure ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        Player player = new Player(username);
        List<Character> heroes = database.getAvailableHeroes();

        System.out.println("\nAvailable Heroes:");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println((i + 1) + ". " + heroes.get(i).toString());
        }

        System.out.print("\nSelect your hero (enter number): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Character selectedHero = heroes.get(choice - 1);
        player.selectHero(selectedHero);

        System.out.println("\nYou have selected: " + selectedHero.getName() + "!");

        boolean running = true;
        Random random = new Random();

        while (running && player.getSelectedHero().isAlive()) {
            Enemy enemy = new Enemy("Minion", 80 + random.nextInt(50), 1 + random.nextInt(3), 30 + random.nextInt(50));
            System.out.println("\nAn enemy \"" + enemy.getName() + "\" appears!");

            while (enemy.isAlive() && player.getSelectedHero().isAlive()) {
                Character hero = player.getSelectedHero();

                System.out.println("\nChoose action:");
                System.out.println("1. Attack");

                if (hero instanceof Mage) {
                    System.out.println("2. Cast Spell");
                } else if (hero instanceof Warrior) {
                    System.out.println("2. Judgment Spin");
                    System.out.println("3. Defend");
                } else if (hero instanceof Archer) {
                    System.out.println("2. Power Shot");
                    System.out.println("3. Dodge");
                }

                System.out.print("> ");
                int action = scanner.nextInt();
                scanner.nextLine();

                if (action == 1) {
                    hero.attack(enemy);
                } else if (hero instanceof Mage && action == 2) {
                    ((Mage) hero).castSpell(enemy);
                } else if (hero instanceof Warrior) {
                    Warrior warrior = (Warrior) hero;
                    if (action == 2) {
                        warrior.judgmentSpin(enemy);
                    } else if (action == 3) {
                        warrior.defend();
                    } else {
                        System.out.println("Invalid action.");
                    }
                } else if (hero instanceof Archer) {
                    Archer archer = (Archer) hero;
                    if (action == 2) {
                        archer.powerShot(enemy);
                    } else if (action == 3) {
                        archer.dodge();
                    } else {
                        System.out.println("Invalid action.");
                    }
                } else {
                    System.out.println("Invalid action.");
                }

                if (enemy.isAlive()) {
                    enemy.attack(hero);
                    System.out.println("Current HP: " + hero.getHealthPoints());
                }
            }

            if (!player.getSelectedHero().isAlive()) {
                player.gameOver();
                running = false;
            } else {
                System.out.println("\n-- YOU DEFEATED THE " + enemy.getName().toUpperCase() + "! --");
                System.out.println("+50 XP");
                player.getSelectedHero().gainExperience(50);

                if (player.getSelectedHero().getExperience() >= 100) {
                    player.getSelectedHero().levelUp();
                }

                System.out.print("\nAnother enemy appears? (y/n): ");
                String cont = scanner.nextLine();
                if (!cont.equalsIgnoreCase("y")) {
                    running = false;
                    System.out.println("Thanks for playing!");
                }
            }
        }
    }
}
