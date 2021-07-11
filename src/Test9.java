import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test9 {
    private static List<Student2> list = Arrays.asList(
        new Student2("a", 88, Student2.Sex.MALE, Student2.City.OSAKA),
        new Student2("b", 90, Student2.Sex.FEMALE, Student2.City.TOKYO),
        new Student2("c", 88, Student2.Sex.FEMALE, Student2.City.OSAKA),
        new Student2("d", 87, Student2.Sex.MALE, Student2.City.TOKYO)
    );

    public static void collectTest1() {
         List<Student2> maleList = list.stream()
            .filter(s->s.getSex() == Student2.Sex.MALE)
            .collect(Collectors.toList());
        maleList.stream().forEach(s->System.out.println(s.getName()));

        Set<Student2> femaList = list.stream()
            .filter(s->s.getSex() == Student2.Sex.FEMALE)
            .collect(Collectors.toCollection(HashSet::new));
        femaList.stream().forEach(s->System.out.println(s.getName()));   
    }

    public static void collectTest2() {
        MaleStudent maleStudents = list.stream()
            .filter(student2 -> student2.getSex() == Student2.Sex.MALE)
            .collect( () -> new MaleStudent(), 
                      (maleStudent, student2) -> maleStudent.accumulate(student2), 
                      (maleStudent1, maleStudent2) -> maleStudent1.combine(maleStudent2)
                    );
        
        maleStudents
            .getList()
            .stream()
            .forEach( Student2 -> System.out.println(Student2.getName()) );
    }

    public static void collectTest3() {
        Map<Student2.Sex, List<Student2>> mapBySex = list.stream()
            .collect(Collectors.groupingBy(Student2::getSex));
        
        for (Student2 student2 : mapBySex.get(Student2.Sex.FEMALE)) {
            System.out.println(student2.getName());
        }
    }

    public static void collectTest4() {
        Map<Student2.City, List<String>> mapByCity = list.stream()
            .collect( Collectors.groupingBy(Student2::getCity,
                      Collectors.mapping(Student2::getName, Collectors.toList()))
            );
        
        mapByCity.get(Student2.City.OSAKA).stream()
            .forEach(name -> System.out.println(name));
    }

    public static void collectTest5() {
        Map<Student2.Sex, Double> mapBySex = list.stream()
            .collect( Collectors.groupingBy(Student2::getSex, 
                      Collectors.averagingDouble(Student2::getScore))
            );
        System.out.println("FEMALE AVERAGE: " + mapBySex.get(Student2.Sex.FEMALE));
        System.out.println("FEMALE AVERAGE: " + mapBySex.get(Student2.Sex.MALE));

        System.out.println();
        Map<Student2.Sex, String> nameMapBySex = list.stream()
            .collect( Collectors.groupingBy(Student2::getSex,
                                            Collectors.mapping( Student2::getName, 
                                                                Collectors.joining(","))
                      )
            );
        System.out.println("FEMALE: " + nameMapBySex.get(Student2.Sex.FEMALE));
        System.out.println("MALE: " + nameMapBySex.get(Student2.Sex.MALE));
    }

}
