package java8inaction.chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PhytagorasTriplets {

  public static void main(String[] args) throws IOException {

    // Stream<Object> i =
    Stream<int[]> pts =
        IntStream
            .rangeClosed(1, 100)
            .boxed()
            .flatMap(
                a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                    .boxed().map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}));
    pts.limit(5).forEach(tuple -> System.out.println(tuple[0] + "," + tuple[1] + "," + tuple[2]));

    Stream<String> streams = Stream.of("akhil", "Nagpal");
    streams.map(String::toUpperCase).forEach(System.out::println);

    int[] arrayi = {1, 2, 3, 4, 5};
    System.out.println(Arrays.stream(arrayi).sum());

    Stream<String> lines =
        Files
            .lines(
                Paths
                    .get("C:/Users/angl/workspace/akhil/src/tryoutlamdas/chapter5/AllStreamOperations.java"),
                Charset.defaultCharset());
    System.out.println(lines.flatMap(line -> Arrays.stream(line.split(""))).distinct().count());

  }
}
