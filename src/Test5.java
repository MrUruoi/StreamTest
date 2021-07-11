import java.util.Arrays;

public class Test5 {
    public static void peekTest() {
        int[] arr = {1, 2, 3, 4, 5};

        int total = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println(n))
            .sum();
        System.out.println(total);
    }
}
