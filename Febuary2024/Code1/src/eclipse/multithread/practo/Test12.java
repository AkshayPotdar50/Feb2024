package eclipse.multithread.practo;

public class Test12 {

	public static void main(String[] args) {
		//here we are going to demonstrate all methods of thread class
		Thread yieldThread = new Thread(()->{
			for(int i =0; i<=5; i++) {
				System.out.println("yieldThread:"+ i);
				Thread.yield();
			}
		});
		
		Thread sleepThread = new Thread(()->{
			for(int i =1; i<=5; i++) {
				System.out.println("sleepThread: "+i);
				
				try {
					Thread.sleep(1000L);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread joinThread1 = new Thread(()->{
			try {
				System.out.println("joinThread1 is starting...");
				Thread.sleep(2000L);
				System.out.println("joinThread is done");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		});
		
		Thread joinThread2 =new Thread(()->{
			try {
				System.out.println("joinThread2 is starting...");
				Thread.sleep(3000L);
				System.out.println("joinThread2 is done");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		});
		
		Object lock = new Object();
		Thread waiThread = new Thread(()->{
			synchronized (lock) {
				try {
					System.out.println("waitThread is waiting...");
					lock.wait();
					System.out.println("waitThread is awake..");
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread notifyThread = new Thread(()->{
			synchronized (lock) {
				try {
					Thread.sleep(2000L);
					System.out.println("notifyThread is notifying..");
					lock.notify();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		yieldThread.start();
		sleepThread.start();
		joinThread1.start();
		joinThread2.start();
		waiThread.start();
		notifyThread.start();
		

	}

}
