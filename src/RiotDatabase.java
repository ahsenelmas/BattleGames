import java.util.ArrayList;
import java.util.List;

public class RiotDatabase {
    private List<Character> availableHeroes;

    public RiotDatabase() {
        availableHeroes = fetchHeroes();
    }

    private List<Character> fetchHeroes() {
        List<Character> availableHeroes = new ArrayList<>();

        availableHeroes.add(new Mage("Lux", 100, 1, 0, 50));
        availableHeroes.add(new Warrior("Garen", 150, 1, 0, 20));
        availableHeroes.add(new Archer("Archi", 120, 1, 0, 40));

        return availableHeroes;
    }

    public List<Character> getAvailableHeroes() {
        return availableHeroes;
    }
}

