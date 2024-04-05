package eclipse.multithread.practo;

import java.util.ArrayList;
import java.util.List;

public class ModuleSort {
	public static List<int[]> findPairs(List<Integer> list, int minDiff, String comparasion){
		List<int[]> pairs = new ArrayList<>();
		list.forEach(i->
				list.stream()
						.filter(j->{
							int diff=i-j;
							return (comparasion.equals("greater") && diff>minDiff)||
									(comparasion.equals("less")&& diff< minDiff);
						})
						.forEach(j->pairs.add(new int[]{i, j}))
		);
		return pairs;

	}






	public static void main(String[] args) {
		List<Integer> list =List.of(1, 2, 3, 4, 5);
		int minDiff=2;

		List<int[]> greaterPairs = findPairs(list, minDiff, "greater");
		System.out.println("Pairs where second number is greater by " + minDiff + ":");
		greaterPairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

		// Find pairs where the second number is less than the first by minDiff
		List<int[]> lessPairs = findPairs(list, minDiff, "less");
		System.out.println("\nPairs where second number is less by " + minDiff + ":");
		lessPairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));

		

	}


	

}
