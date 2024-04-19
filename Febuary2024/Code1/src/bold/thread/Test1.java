package bold.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class MycustomException extends Exception{

    public MycustomException(){
        super("this is custom exception");
    }

    public MycustomException(String message){
        super(message);
    }
}

class Book{

    private String tittle;
    private String author;
    private int year;
    private double price;

    public Book(String tittle, String author, int year, double price) {
        this.tittle = tittle;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

}

class Person implements Cloneable{
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test1 {
    public static void main(String[] args) {
        Person person1 = new Person("akshay");
        Person person2 = person1;
       // System.out.println(person1.name);
       // System.out.println(person2.name);

        //find the longest and shortest word in given array
        String [] array1 ={"akshay", "kolhapur", "iitm", "ashta", "gauri"};
        String Longest = Arrays.stream(array1)
                .reduce((str1, str2)->str1.length() > str2.length() ? str1:str2).get();
        String Shortest =Arrays.stream(array1)
                .reduce((Str1, Str2)->Str1.length() < Str2.length() ? Str1:Str2 ).get();

      /*  System.out.println(Longest);
        System.out.println(Shortest);*/

        //convert half of string in uppercase and half in lowercase

        String example ="this is spring tutorial this is spring tutorial";
        int mid =example.length()/2;
        StringBuilder uppercase = new StringBuilder();
        StringBuilder lowercase = new StringBuilder();
        for(int i =0; i<example.length(); i++){
            if(i<=mid){
                lowercase.append(Character.toLowerCase(example.charAt(i)));
            }else{
                uppercase.append(Character.toUpperCase(example.charAt(i)));
            }

        }
       // System.out.println(uppercase +lowercase.toString());

          //forming number
        String [] as1 ={"88", "45", "55", "84"};
        //System.out.println(formTheLargestNumber(as1));

        List<Book> books = Arrays.asList(
                new Book("java 8 in action", "akshay potddar", 2014, 40),
                new Book("effective java", "joshua bloch", 2008, 35.0),
                new Book("clean code", "robert c", 2008, 35.0),
                new Book("the programmer", "andrew hunt", 1999, 50)
        );

        //print subtittles of books published after 2008
       // System.out.println("tittles of books published after 2000");
        books.stream().filter(book->book.getYear()>2000)
                .map(Book::getTittle)
                .forEach(System.out::println);
        System.out.println("***********************************************");


        // FAIL SAFE AND FAIL FAST
        List<String> list = new ArrayList<>();
        list.add("akshay");
        list.add("kehsav");

        Iterator<String> iterator= list.iterator();
        list.add("smita");
        try{
            while(iterator.hasNext()){
                String item = iterator.next();
                System.out.println(item);
            }
        }catch (Exception e){
            System.out.println("Exception" +e.getClass().getSimpleName());
        }
        System.out.println("***********************************************************");

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("item 1");
        list1.add("item2");
        list1.add("item3");

        Iterator<String> iterator1 =list1.iterator();
        list1.add("new item");

        while(iterator1.hasNext()){
            String item = iterator1.next();
            System.out.println(item);
        }

        String inputString = "Hello, World";
        StringBuilder stringBuilder = new StringBuilder(inputString);
        Map<String, Integer> map = new HashMap<>();
        map.put("first", stringBuilder.indexOf("o"));
        map.put("last", stringBuilder.lastIndexOf("o"));
        System.out.println(map);
        System.out.println("*********************************");

         String input4 ="hello world 123";
         long vowelCount =input4.chars()
                 .mapToObj((ch)-> (char)ch)
                 .map(Character::toLowerCase)
                 .filter(ch->"aeiou".contains(String.valueOf(ch)))
                 .count();
        System.out.println(vowelCount);
        System.out.println("********************************************");

        long consonantCount =input4.chars()
                .mapToObj(ch->(char)ch)
                .map(Character::toLowerCase)
                .filter(ch->Character.isLetter(ch) && !"aeiou".contains(String.valueOf(ch))).count();
        System.out.println(consonantCount);
        System.out.println("*****************************************");


        long digitCount =input4.chars().filter(Character::isDigit).count();
        System.out.println(digitCount);
        System.out.println("******************************************");

        long whiteSpaceCount =input4.chars().filter(Character::isWhitespace).count();
        System.out.println(whiteSpaceCount);

          String str4="aks1457";
          int numeric = Integer.parseInt(str4);
        System.out.println(numeric);

        //program for finding the pairs
        List<Integer> rating = Arrays.asList(1, 2, 3, 4, 5, 6);
        int minDiff =4;

        System.out.println(maxPairs(rating, minDiff));
        System.out.println(onePairs(rating, minDiff));
        System.out.println(lessThan(rating, minDiff));
        System.out.println(sumTo(rating, 10));

        System.out.println("***************************************");

        try{
            int age =-1;
            if(age <= 0){
                throw new MycustomException("age cannot be negative");
            }
        }catch (MycustomException var2){
            System.out.println("caught custom exception" +var2.getMessage());
        }

        System.out.println("/////////////////////////////////////////////////");

       String strp1 ="akshay";
       String strp2="ashish";
        System.out.println(checkAnagram(strp1, strp2));
        System.out.println(checkPalindrome(strp1));









    }
    //form the largest and smallest number using string array
    public static String formTheLargestNumber(String[] arr){
        Arrays.sort(arr, (num1, num2)-> (num2+num1).compareTo(num1+num2));
        StringBuilder str1 = new StringBuilder();
        for(String s:arr){
            str1.append(s);
        }
        return str1.toString();
    }

    public static String removeCansonant(String input){
        return input.toLowerCase().replaceAll("[^aeiou]", " ");
    }

    public static int maxPairs(List<Integer> rating, int minDiff) {
        return (int)rating.stream()
                .sorted()
                .flatMap((i) -> rating.stream().map((j) -> new int[]{i, j}))
                .filter((pair) -> Math.abs(pair[0] - pair[1]) >= minDiff)
                .count() / 2;
    }

    public static int onePairs(List<Integer> ratings, int minDiff){
       return(int) ratings.stream()
               .distinct()
               .filter((i)->i<=minDiff)
               .count();
    }
    private static int lessThan(List<Integer> ratings, int minDiff){
        return (int) ratings.stream()
                .distinct()
                .filter((value)->value >minDiff)
                .count();
    }

    public static long sumTo(List<Integer> rating, int sum) {
        return rating.stream()
                .sorted()
                .flatMap((i) -> rating.stream()
                        .map((j) -> new int[]{i, j}))
                .filter((pair) -> pair[0] + pair[1] == sum)
                .count();
    }

    private static int maxStudentPairs(List<Integer> rating, int minDiff) {
        return (int)rating.stream()
                .sorted()
                .flatMap((i) -> rating.stream()
                        .map((j) -> new int[]{i, j}))
                .filter((pair) -> Math.abs(pair[1] - pair[0]) >= minDiff && pair[1] > pair[0])
                .count();
    }

    public static boolean checkAnagram(String str1, String str2){
        str1 = str1.replaceAll("//s", " ");
        str2=str2.replaceAll("//s", " ");
        return Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
    }


    public static boolean checkPalindrome(String str1){
        for(int i=0; i< str1.length()/2; i++){
            if(str1.charAt(i) != str1.charAt(str1.length()-i-1)){
                return false;
            }

        }
        return true;
    }


}


