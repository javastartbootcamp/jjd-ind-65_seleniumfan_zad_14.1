import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUtils {
    static List<Integer> createList(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (InputStream resource = ListUtils.class.getClassLoader().getResourceAsStream(fileName);
             Scanner scanner = new Scanner(resource)) {
            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextInt());
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Cannot read the file " + fileName, e);
        }
        return numbers;
    }
}
