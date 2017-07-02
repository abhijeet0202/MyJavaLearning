package MultiThreading;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsPrintNumInSeq {
	
	

	public static void main(String[] args) {
		System.out.println("Enter Total No. of Thread");
		int numOfThreads= new Scanner(System.in).nextInt();
		for (int i = 1;i <=numOfThreads;i++){
			new Thread(new Printer(i, numOfThreads), "T"+i).start();;
		}
		//Thread t1 = new Thread(new Printer(1, 3), "T1");
		//Thread t2 = new Thread(new Printer(2, 3), "T2");
		//Thread t3 = new Thread(new Printer(3, 3), "T3");

		//t1.start();
		//t3.start();
		//t2.start();
	}

}

class Printer implements Runnable {
	public volatile static AtomicInteger number = new AtomicInteger(1);
	int threadId;
	int numOfThreads;

	Printer(int threadId, int numOfThreads) {
		this.threadId = threadId;
		this.numOfThreads = numOfThreads;
	}

	@Override
	public void run() {
		print();
	}

	private void print() {
		//System.out.println(0/3);
		try {
			while (true) {
				
				synchronized (number) {
					//System.out.println(number.get());
					if ((number.get() % numOfThreads == this.threadId) || ((number.get() % numOfThreads == 0)&&(this.threadId == numOfThreads))){
						System.out.println("Thread ID: "+threadId+ "Print: "+number.getAndIncrement());
						number.notifyAll();
						//monitor.wait();
					}else{
						//System.out.println("Thread ID: "+threadId + "current value:" +number.get());
						Thread.sleep(1000);
					}

				}
			}
			// System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
