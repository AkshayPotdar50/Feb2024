package com.dev.day1;

public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


    public static void main(String[] args) {
        Thread thread1 =new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread1: holding lock1....");
                try{Thread.sleep(100);}
                catch (InterruptedException ignored){}
                System.out.println("Thread1: waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread1: Acquired lock2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                try { Thread.sleep(100); }
                catch (InterruptedException ignored) {}
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
