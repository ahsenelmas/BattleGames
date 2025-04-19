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

        System.out.println("\nYou have selected " + selectedHero.getName() + "!");
        System.out.println("\n--- Battle Start! ---");

        boolean running = true;
        Random random = new Random();

        while (running && player.getSelectedHero().isAlive()) {
            Enemy enemy = new Enemy("Minion", 80 + random.nextInt(40), 1 + random.nextInt(2), 30 + random.nextInt(20));
            System.out.println("\nAn enemy \"" + enemy.getName() + "\" appears!");

            while (enemy.isAlive() && player.getSelectedHero().isAlive()) {
                System.out.println("\nChoose action:");
                System.out.println("1. Attack");
                if (player.getSelectedHero() instanceof SpellCaster) {
                    System.out.println("2. Cast Spell");
                }
                System.out.print("> ");
                int action = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (action == 1) {
                    player.getSelectedHero().attack(enemy);
                } else if (action == 2 && player.getSelectedHero() instanceof SpellCaster) {
                    ((SpellCaster) player.getSelectedHero()).castSpell(enemy);
                } else {
                    System.out.println("Invalid action.");
                    continue;
                }

                if (enemy.isAlive()) {
                    enemy.attack(player.getSelectedHero());
                    System.out.println("Current HP: " + player.getSelectedHero().getHealthPoints());
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

        scanner.close();
    }
}
