package overview;

import java.lang.annotation.Repeatable;

/**
 * Created by adrian on 25.12.16.
 */
public class Annotations {

    public static void main(String... args) {

    }

}

@interface Hints {
    Hint[] value();
}
@Repeatable(Hints.class)
@interface Hint {
    String value();
}

// Variant 1: Container Annotation
@Hints({@Hint("hint1"), @Hint("Hint2")})
class Person1 {}

// Variant 2: Repeatable annotations
@Hint("hint1")
@Hint("hint2")
class Person2 {}

