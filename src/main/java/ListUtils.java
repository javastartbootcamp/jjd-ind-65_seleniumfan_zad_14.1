import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUtils {
    static List<Integer> createList(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextInt());
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Cannot read the file " + fileName, e);
        }
        return numbers;
    }
}
