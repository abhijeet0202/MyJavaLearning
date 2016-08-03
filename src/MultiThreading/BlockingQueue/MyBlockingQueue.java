package MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingQueueProducer implements Runnable {
	private final BlockingQueue<String> queue;

	BlockingQueueProducer(BlockingQueue<String> q) {
		queue = q;
	}

	public void run() {
		try {
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BlockingQueueConsumer implements Runnable {
	private final BlockingQueue<String> queue;

	BlockingQueueConsumer(BlockingQueue<String> q) {
		queue = q;
	}

	public void run() {
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public final class MyBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<String> myArrayBlockingQueue = new ArrayBlockingQueue<String>(2);
		// BlockingQueue<Integer> mySynchronousQueue = new SynchronousQueue<>();

		BlockingQueueProducer p = new BlockingQueueProducer(myArrayBlockingQueue);

		BlockingQueueConsumer c1 = new BlockingQueueConsumer(myArrayBlockingQueue);
		BlockingQueueConsumer c2 = new BlockingQueueConsumer(myArrayBlockingQueue);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();

	}

}
