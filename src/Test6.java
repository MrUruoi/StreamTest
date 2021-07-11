import java.util.Arrays;

// allMatch, anyMatch, noneMatch
public class Test6 {
    public static void matchTest() {
        int[] arr = {2, 4, 6};
        
        boolean result1 = Arrays.stream(arr).allMatch( n -> n%2 == 0 );
        boolean result2 = Arrays.stream(arr).anyMatch( n -> n%2 == 0 );
        boolean result3 = Arrays.stream(arr).noneMatch( n -> n%2 == 0 );
        
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }
}
