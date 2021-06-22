package MultiThreading;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class ThreadsPrintNumInSeq {

	public static void main(String[] args) {
		System.out.println("Enter Total No. of Thread");
		int numOfThreads = new Scanner(System.in).nextInt();
		for (int i = 1; i <= numOfThreads; i++) {
			new Thread(new Printer(i, numOfThreads), "T" + i).start();
			;
		}
	}

}

class Printer implements Runnable {
	public volatile static AtomicInteger number = new AtomicInteger(1);
	Predicate<Integer> myCheck = threadId ->((number.get() % this.numOfThreads == threadId)|| ((number.get() % this.numOfThreads == 0) && (threadId == this.numOfThreads)));
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
		try {
			while (true) {
				synchronized (number) {
					//if ((number.get() % numOfThreads == this.threadId)|| ((number.get() % numOfThreads == 0) && (this.threadId == numOfThreads))) {
					if(myCheck.test(threadId)) {// USing Predicate
						System.out.println("Thread ID: " + threadId + "Print: " + number.getAndIncrement());
						number.notifyAll();
						Thread.sleep(1000);
					} else {
						//System.out.println("Thread ID: " + threadId + "current value:" + number.get());
						number.wait();
					}

				}
			}
			// System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
