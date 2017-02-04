package overview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adrian on 25.12.16.
 */
public class Maps {
    public static void main(String... args) {
        Map<Integer, String> map = new HashMap<>();

        for(int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.putIfAbsent(3, "new");  // does not get inserted

        map.forEach((key, val) -> System.out.println(key + " "  + val));


        // Compute in Map
        map.computeIfPresent(3, (key, val) -> val + key);
        System.out.println(map.get(3));

        map.computeIfAbsent(19, key -> "asdf");
        System.out.println(map.get(19));

        map.computeIfAbsent(4, key -> "asdf");
        System.out.println(map.get(4));

        // Remove only if value is mapped
        map.remove(3, "??");
        System.out.println(map.get(3)); // Nothing removed

        map.remove(3, "val33");
        System.out.println(map.get(3)); // removed

        // Default Get
        System.out.println(map.getOrDefault(100, "default"));

        // Merge entries
        map.merge(9, "val9", (val, newVal) -> val.concat(newVal.toUpperCase()));
        System.out.println(map.get(9));

        map.merge(9, "hello", (val, newVal) -> val.concat(newVal.toUpperCase()));
        System.out.println(map.get(9));
    }
}
