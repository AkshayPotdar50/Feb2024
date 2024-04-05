package eclipse.multithread.practo;

import java.util.*;

public class ArrayIndex {
	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5};
		
		
		//rearrange the element such thateven and odd
		int [] rearrangedArray=Arrays.stream(arr)
				.mapToObj(Integer::valueOf)
				.sorted((a,b)->(b%2)-(a%2))
				.mapToInt(Integer::intValue)
				.toArray();
		System.out.println(Arrays.toString(rearrangedArray));
		
		String inputString = "Hello, World";
        StringBuilder stringBuilder = new StringBuilder(inputString);
        Map<String, Integer> map =new HashMap<>();
      map.put("first", stringBuilder.indexOf("o"));
        map.put("last", stringBuilder.lastIndexOf("o"));
        System.out.println(map);
        
        String s1 ="akshay";
       String s2= removeConsonant(s1);
       System.out.println(s2);
	}
	
    public static String removeConsonant(String input){
        return input.toLowerCase().replaceAll("[!^aeiou\\s]", " ");
    }


}
