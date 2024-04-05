package dsa.sorting.pract;

public class Author {
    private String name;
    private int age;
    private String bookName;

    public Author(String name, int age, String bookName) {
        this.name = name;
        this.age = age;
        this.bookName = bookName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
