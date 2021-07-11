import java.util.Arrays;
import java.util.List;

// flatMap, map
public class Test3 {
    
    public static void flatMapTest() {
        List<String> list = Arrays.asList("qwer asdf", "zxcv 1234");
        list.stream()
            .flatMap( e -> Arrays.stream(e.split(" ")) )
            .forEach(e -> System.out.println(e));
        System.out.println();

        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        list2.stream().flatMapToInt( e -> {
            String[] strArr = e.split(",");
            int[] intArr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i].trim());
            }
            return Arrays.stream(intArr);
         })
        .forEach(e -> System.out.println(e));
    }

    public static void mapTest() {
        List<Student> students = Arrays.asList(
            new Student("a", 88),
            new Student("b", 100),
            new Student("c", 68)
        );
        
        students.stream()
            .mapToInt(student -> student.getScore())
            .forEach(score->System.out.println(score));
    }

}



