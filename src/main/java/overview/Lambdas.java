package overview;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.*;

public class Lambdas {

    public static void main(String... args) {
        List<String> persons = Arrays.asList("Anna", "Hans", "Max", "Peter");

        // Non-lambda way
        Collections.sort(persons, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return t1.compareTo(s);
            }
        });

        System.out.println(persons);
        Collections.shuffle(persons);

        // Shorter
        Collections.sort(persons, (String a, String b) -> {
            return b.compareTo(a);
        });

        System.out.println(persons);
        Collections.shuffle(persons);

        // Even Shorter
        Collections.sort(persons, (String s1, String s2) -> s2.compareTo(s1));

        System.out.println(persons);
        Collections.shuffle(persons);

        // Final
        Collections.sort(persons, (s1, s2) -> s2.compareTo(s1));

        System.out.println(persons);

    }

}