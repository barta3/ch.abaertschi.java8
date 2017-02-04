package overview;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by adrian on 18.12.16.
 */
public class FunctionaInterfaces {

    public static void main(String... args) {

        // Predicates (one argument, return boolean)

        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("asdf"));

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        System.out.println(nonNull.and(predicate).test(null));
//        System.out.println(predicate.and(nonNull).test(null)); // NPE

        // Functions (one argument, return result

        Function<Integer, Integer> square = i -> i * i;
        Function<Integer, Integer> doubleIt = i -> i * 2;

        System.out.println(square.andThen(doubleIt).apply(3)); // (3²) * 2
        System.out.println(square.compose(doubleIt).apply(3)); //  (3 * 2)²


        // Supplier (no argument, return result)
        Supplier<Object> os = Object::new;
        Object o = os.get();

        // Consumer (one argument, no return value
        Consumer<String> greeter = (s) -> System.out.println("Hello " + s);
        greeter.accept("Max");

        // Comparators
        Comparator<Person> personComparator = Comparator.comparing(p -> p.firstName);
        PersonFactory pf = Person::new;
        personComparator.compare(pf.create("Max", "Muster"), pf.create("a", "b"));


        // Optionals (actually not Functional Interfaces
        Optional<String> optional = Optional.of("");

        System.out.println(optional.get());
        System.out.println(optional.isPresent());
        System.out.println(optional.orElseGet(String::new));

    }
}
