import java.util.Arrays;
import java.util.OptionalInt;

// count, max, sum, min, findFirst, average
public class Test7 {
    public static void countTest() {
        long count = Arrays.stream(new int[]{1, 2, 3, 4, 5})
            .filter(n->n%2==0)
            .count();
        System.out.println(count);
    }

    public static void maxTest() {
        OptionalInt max = Arrays.stream(new int[]{1, 2, 3, 4, 5})
            .filter(n->n%2==0)
            .max();

        if(max.isPresent()) System.out.println(max);
    }
}
