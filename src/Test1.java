import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {
    public static void test1() {
        List<String> list = Arrays.asList("qwer", "asdf", "zxcv");

        // Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Stream
        Stream<String> stream = list.stream();
        stream.forEach( name -> System.out.println(name) );
        System.out.println();
        
        // PararellStream
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach( name -> {
            System.out.println(name + ":" + Thread.currentThread().getName());
        });
    }
}