package MultiThreading.Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		
		final CyclicBarrier cb = new CyclicBarrier(3);
		
		Thread cacheService = new Thread(new cbService("CacheService", 1000, cb));
		Thread alertService = new Thread(new cbService("AlertService", 1000, cb));
		Thread validationService = new Thread(new cbService("ValidationService", 1000, cb));

		
		cacheService.start(); // separate thread will initialize CacheService
		alertService.start(); // another thread for AlertService initialization
		validationService.start();

		/* application should not start processing any thread until all service is up and ready to do there job.
		   Countdown latch is idle choice here, main thread will start with count 3 and wait until count reaches zero. each thread once up and read will
		   do a count down. this will ensure that main thread is not started processing until all services is up.
		   
		   count is 3 since we have 3 Threads (Services) */

		try {
			try {
				cb.await();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

/**
 * Service class which will be executed by Thread using CountDownLatch
 * synchronizer.
 */
class cbService implements Runnable {
	private final String name;
	private final int timeToStart;
	private final CyclicBarrier cb;

	public cbService(String name, int timeToStart, CyclicBarrier cb) {
		this.name = name;
		this.timeToStart = timeToStart;
		this.cb = cb;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToStart);
		} catch (InterruptedException ex) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(name + " is Up");
		
		try {
			Thread.sleep(timeToStart+ 100);
		} catch (InterruptedException ex) {
			Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(cb.getNumberWaiting());
		//cb.reset();
	}
}
