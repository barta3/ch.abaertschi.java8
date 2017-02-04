package avoidnull;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by adrian on 28.12.16.
 * Based on http://winterbe.com/posts/2015/03/15/avoid-null-checks-in-java/
 */
public class Structure {

    public static void main(String... args) {
        Outer outer = new Outer();

        // Lots of null Checks
        if(outer!= null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner);
        }

        // Optional
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);

        // Supplier function
        Outer o = new Outer();
        resolve(() -> o.getNested().getInner().getFoo())
                .ifPresent(System.out::println);
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException e) {
            return Optional.empty();
        }
    }



}
class Outer {
    Nested nested;
    Nested getNested() {
        return nested;
    }
}
class Nested {
    Inner inner;
    Inner getInner() {
        return inner;
    }
}
class Inner {
    String foo;
    String getFoo() {
        return foo;
    }
}
