package eclipse.multithread.practo;

import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchingAlgo {
    public static OptionalInt linearSearch(int[] array1, int target){
        return IntStream.range(0, array1.length)
                .filter((i)-> array1[i] ==target)
                .findFirst();
    }

    public static OptionalInt binarySearch(int[] array2, int target){
        int left=0;
        int right=array2.length-1;

        while(left <= right){
            int mid=left +(right-left)/2;
            if(array2[mid] ==target){
                return OptionalInt.of(mid);
            }

            if(array2[mid] <target){
                left =mid +1;
            }else{
                right =mid-1;
            }
        }
        return OptionalInt.empty();
    }

    private static Map<Character, Long> countCharacter(String input){
        return input.chars()
                .mapToObj((c)->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}
