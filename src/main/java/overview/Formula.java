package overview;

/**
 * Created by adrian on 10.12.16.
 * Default Methods for Interfaces
 */
interface Formula {
    double calc(int a);

    default double sqrt (int a) {
        return Math.sqrt(a);
    }

    class Demo {
        Formula f = new Formula() {
            @Override
            public double calc(int a) {
                return sqrt(a * 10);
            }
        };

        public static void main(String... args) {
            System.out.println(new Demo().f.calc(10));
            System.out.println(new Demo().f.sqrt(100));
        }
    }
}
