package overview;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by adrian on 18.12.16.
 */
public class Streams {

    public static void main(String... args) {
        List<String> elements = Arrays.asList("hhh", "h2h", "m2m", "aaa", "zzz", "ydc");

        // Filter
        elements.stream()
                .filter((s) -> s.startsWith("h"))
                .forEach(System.out::println);

        // Sorted
        System.out.println();
        elements.stream()
                .sorted()
                .forEach(System.out::println);

        // Map
        System.out.println();
        elements.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        // Match
        System.out.println();
        boolean b1 = elements.stream().anyMatch((s) -> s.startsWith("a"));
        System.out.println(b1);
        boolean b2 = elements.stream().allMatch((s) -> s.contains("h"));
        System.out.println(b2);
        boolean b3 = elements.stream().noneMatch(String::isEmpty);
        System.out.println(b3);

        // Count
        System.out.println();
        System.out.println(elements.stream().filter((s) -> s.endsWith("h")).count());

        // Reduce
        System.out.println();
        Optional<String> reduce = elements.stream()
                .reduce((s1, s2) -> s1 + "-" + s2);
        System.out.println(reduce);

    }
}
