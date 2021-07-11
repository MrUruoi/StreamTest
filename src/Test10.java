import java.util.Arrays;
import java.util.List;

public class Test10 {
    private static List<Student2> list = Arrays.asList(
        new Student2("a", 88, Student2.Sex.MALE, Student2.City.OSAKA),
        new Student2("b", 90, Student2.Sex.FEMALE, Student2.City.TOKYO),
        new Student2("c", 88, Student2.Sex.FEMALE, Student2.City.OSAKA),
        new Student2("d", 87, Student2.Sex.MALE, Student2.City.TOKYO)
    );

    public static void parallelStreamTest() {
        MaleStudent maleStudent = list.parallelStream()
            .filter(student2 -> student2.getSex() == Student2.Sex.MALE)
            .collect(
                () -> new MaleStudent(),
                (r, t) -> r.accumulate(t),
                (r1, r2) -> r1.combine(r2)
            );
        maleStudent.getList().stream()
        .forEach(student2 -> System.out.println(student2.getName()));
    }
}

/* ForkJoin Framework
    fork phase
    join phase

    FrokJoinPool
*/

/* 병렬 처리에 영향을 미치는 요인
 - 요소의 수와 요소당 처리시간
 - 스트림 소스의 종류
 -- ArrayList, 배열은 랜덤 액세스 지원(인덱스 접근) 병렬 처리 시간 절약
 -- HashSet, TreeSet 등은 요소 분리 어려움
 -- LinkedList 랜덤 액세지 미지원 요소 분리 어려움
 - 코어의 수
*/