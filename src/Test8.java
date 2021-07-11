import java.util.Arrays;
import java.util.List;

// reduce
public class Test8 {
    public static void reduceTest() {
        List<Student> list = Arrays.asList(
            new Student("a", 92),
            new Student("b", 88),
            new Student("c", 82)
        );

        int sum1 = list.stream()
            .mapToInt(Student::getScore)
            .sum();
        System.out.println(sum1);

        int sum2 = list.stream()
            .mapToInt(Student::getScore)
            .reduce((a,b) -> a + b)
            .getAsInt();
        System.out.println(sum2);

        int sum3 = list.stream()
            .mapToInt(Student::getScore)
            .reduce(0, (a,b) -> a+b);
        System.out.println(sum3);
    }
}
