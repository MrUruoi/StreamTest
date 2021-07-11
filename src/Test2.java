import java.util.Arrays;
import java.util.List;

// distinct, filter
public class Test2 {
    private static List<String> list = Arrays.asList("qwer", "asdf", "qwer", "zxcv", "qaz");
    
    public static void distinctTest() {
        list.stream()
            .distinct()
            .forEach(e -> System.out.println(e));
    }

    public static void filterTest() {
        list.stream()
        .filter(e->e.startsWith("q"))
        .forEach(e -> System.out.println(e));
    }
}
