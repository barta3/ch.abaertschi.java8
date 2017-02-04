package overview;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by adrian on 18.12.16.
 */
public class ParallelStreams {

    public static void main(String... args) {
        int num = 1_000_000;
        List<String> values = new ArrayList<>(num);

        for(int i = 0; i < num; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        // Sequential
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();

        System.out.println("Sequential sort: " + TimeUnit.NANOSECONDS.toMillis(t1 - t0));

        // Parallel
        t0 = System.nanoTime();
        count = values.parallelStream().sorted().count();
        System.out.println(count);
        t1 = System.nanoTime();

        System.out.println("Parallel sort: " + TimeUnit.NANOSECONDS.toMillis(t1 - t0));


    }
}
