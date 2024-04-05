package eclipse.multithread.practo;

import java.util.*;
import java.util.stream.Stream;

public class Iterator1{
    public static void main(String[] args) {
        HashMap<Integer, String> hashmap=new HashMap<>();
         hashmap.put(1, "potdar");
         hashmap.put(2, "pandit");
         hashmap.put(3, "patil");

         Map<Integer, String> linkmap = new LinkedHashMap<>(hashmap);
         for(Map.Entry<Integer, String> entry2:linkmap.entrySet()){
             System.out.println("  key  "+entry2.getKey() +"  value  "+entry2.getValue());
         }

        System.out.println("*****************************************");

        for (Map.Entry<Integer, String> entry : hashmap.entrySet()) {
            System.out.println("  key  " + entry.getKey() + "  value  " + entry.getValue());

        }

        System.out.println("**************************************************");
          Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        TreeMap<Integer, String> treemap = new TreeMap<>(reverseComparator);
        treemap.putAll(linkmap);
        for(Map.Entry<Integer, String > entry3:treemap.entrySet()){
            System.out.println("   key  "+entry3.getKey() +"  value  "+entry3.getValue());

        }

        //fibonacci series
        int N=15;
        int num1=0;
        int num2=1;
        System.out.println("fibonacci series is N ="+N);
        System.out.println(num1+" "+num2);
        int i=2;
        while(i<=N){
            i++;
            while(i<=N){
                i++;
              int temp=num1+num2;
              num1=num2;
              num2=temp;
                System.out.println(" "+num2);

            }
        }
        System.out.println("***********************************");
        int n=10;
        Stream.iterate(new int[]{0,1},fib->new int[]{fib[1], fib[0]+fib[1]})
                .limit(n)
                .forEach(fib-> System.out.println(fib[0]));




    }


}
