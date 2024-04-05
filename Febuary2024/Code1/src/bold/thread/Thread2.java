package bold.thread;

public class Thread2 {

    public static void main(String[] args) {
        Thread thread6 = new Thread(()->{
            for(int i=0; i<10; i++){
                System.out.println("Thread2 is running" +i);
                try{
                    Thread.sleep(10000);

                    Thread.yield();

                    if(i == 3){
                        Thread thread3 = new Thread();
                        System.out.println("Thraed3 start executing");
                        try {
                            Thread.sleep(2000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("Thread3 completed");


                        thread3.start();
                        thread3.join();
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        });
        Thread2 thread2 = new Thread2();


        thread6.start();

    }
}
