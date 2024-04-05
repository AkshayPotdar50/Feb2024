package eclipse.multithread.practo;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {



    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "world", "stream", "hello", "world", "map");
        List<String> distictWords= words.stream()
                .map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        System.out.println(distictWords);
    }
}
