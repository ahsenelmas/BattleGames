import java.util.ArrayList;
import java.util.List;

public class RiotDatabase {
    private List<Character> availableHeroes;

    public RiotDatabase() {
        availableHeroes = fetchHeroes();
    }

    private List<Character> fetchHeroes() {
        List<Character> heroes = new ArrayList<>();

        heroes.add(new Mage("Lux", 100, 1, 0, 50));
        heroes.add(new Warrior("Garen", 150, 1, 0, 20));

        return heroes;
    }

    public List<Character> getAvailableHeroes() {
        return availableHeroes;
    }
}

