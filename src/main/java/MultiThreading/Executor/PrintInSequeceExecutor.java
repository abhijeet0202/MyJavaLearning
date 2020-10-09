package MultiThreading.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintInSequeceExecutor {

	public static void main(String[] args) {
		System.out.println("Enter Number oF Threads");
		Scanner scan = new Scanner(System.in);
		int nThreads = scan.nextInt();
		ExecutorService ex = Executors.newFixedThreadPool(nThreads);
		for (int i = 0; i < nThreads; i++) {
			ex.submit(new Printer(i + 1, nThreads));
		}
	}

}

class Printer implements Runnable {
	int threadId;
	int noOfThreads;
	private static volatile AtomicInteger data = new AtomicInteger(1);

	Printer(int threadId, int noOfThreads) {
		this.threadId = threadId;
		this.noOfThreads = noOfThreads;
	}

	@Override
	public void run() {
		print();
	}

	public void print() {
		try {
			while (true) {
				synchronized (data) {
					if (data.get() % noOfThreads == threadId
							|| data.get() % noOfThreads == 0 && threadId == noOfThreads) {
						System.out.println("Thread ID: " + threadId + " printing data: " + data.getAndIncrement());
						data.notifyAll();
						Thread.sleep(1000);
					} else {
						data.wait(10);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}