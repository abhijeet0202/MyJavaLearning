package Programs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintInSequence {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);

		for (int i = 0; i <= 2; i++) {
			ex.submit(new OddEven(i+1, 2));
		}
	}

}

class OddEven implements Runnable {
	int threadId;
	int nofThreads;
	private static volatile AtomicInteger data = new AtomicInteger(1);

	OddEven(int threadId, int nofThreads) {
		this.threadId = threadId;
		this.nofThreads = nofThreads;
	}

	@Override
	public void run() {
		print();

	}
	
	public void print() {
		try {
			while (data.get()<20) {
				synchronized (data) {
					if (data.get() % nofThreads == threadId || data.get() % nofThreads == 0 && threadId == nofThreads) {
						System.out.println("Thread ID:: " + threadId + " PRINTING -> " + data.getAndIncrement());
						data.notifyAll();
						//Thread.sleep(1000);
					} else {
						data.wait(10);
					}
				}
			}

		} catch (Exception ex1) {

		}
	}
}