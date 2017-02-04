package overview;

/**
 * Created by adrian on 18.12.16.
 */
public class LambdaScopes {

    public static void main(String... args) {

        // explicit final
        final int f = 0;
        Converter<Integer, String> is = (from) -> String.valueOf(from + f);

        is.convert(3);

        // implicit final
        int f2 = 2;
//        f2 = 3; // does not compile
        Converter<Integer, String> is2 = (from) -> String.valueOf(from + f2);
        is2.convert(f2);

    }
}
