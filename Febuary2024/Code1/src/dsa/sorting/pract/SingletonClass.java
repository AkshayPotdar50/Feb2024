package dsa.sorting.pract;

public class SingletonClass {
    private static volatile SingletonClass instance;

    private SingletonClass() {
    }

    public static SingletonClass getInstance(){
        if(instance ==null){
            synchronized (SingletonClass.class){
                if(instance==null){
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

}

class TestSingleTon{
    public static void main(String[] args) {
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 =SingletonClass.getInstance();
        if(instance1==instance2){
            System.out.println("both are same objects");
        }else{
            System.out.println("the class is not singleton");
        }
    }
}
