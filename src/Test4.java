import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

// sorted
public class Test4 {
    
    public static void sortedTest1() {
        IntStream intStream = Arrays.stream(new int[]{5, 3, 2, 4, 1});
        intStream.sorted().forEach(n->System.out.println(n));
    }

    public static void sortedTest2() {
        List<StudentComparable> list = Arrays.asList(
          new StudentComparable("a", 88),
          new StudentComparable("b", 90),
          new StudentComparable("c", 77)
        );

        list.stream()
            .sorted()
            .forEach(s->System.out.println(s.getName()+" "+s.getScore()));
        System.out.println();
        list.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(s->System.out.println(s.getName()+" "+s.getScore()));
    }
}
