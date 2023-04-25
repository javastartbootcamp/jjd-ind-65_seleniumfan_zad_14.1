import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    private static final String FILE_NAME = "liczby.txt";

    public static void main(String[] args) {
        List<Integer> numbers = ListUtils.createList(FILE_NAME);
        Map<Integer, Integer> mapWithNumberOccurrences = createMapWithNumberOccurrences(numbers);

        printStats(mapWithNumberOccurrences);
    }

    private static void printStats(Map<Integer, Integer> mapWithNumberOccurrences) {
        Set<Map.Entry<Integer, Integer>> entries = mapWithNumberOccurrences.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
        }
    }

    private static Map<Integer, Integer> createMapWithNumberOccurrences(List<Integer> numbers) {
        Map<Integer, Integer> stats = new TreeMap<>();
        for (Integer number : numbers) {
            if (stats.containsKey(number)) {
                int numberOfOccurrences = stats.get(number);
                stats.put(number, ++numberOfOccurrences);
            } else {
                stats.put(number, 1);
            }
        }
        return stats;
    }
}
