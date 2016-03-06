/**
 * 
 */
package MultiThreading;

/**
 * @author abhibane
 *
 */
public class MultipleThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyThread("one");
		new MyThread("Two");
		new MyThread("Three");
		
		try{
			System.out.println("Main Sleeping");
			Thread.sleep(1000);
			System.out.println("Main Awake");
		} catch (InterruptedException ex){
			System.out.println("Value of exp:"+ex.toString() );
		}
	}
}

class MyThread implements Runnable{
	
	Thread thread;
	String threadname;
	
	public MyThread(String name) {
		threadname = name;
		thread = new Thread(this, name);
		System.out.println("Starting Thread:"+thread);
		thread.start();
	}
	
	public void run(){
		try{
			for (int i =0; i<5; i++){
				System.out.println("Child Thread Information:\n Thread Name:"+thread.getName()+"\n Thread ID"+thread.getId()+"\n Thread Priority"+thread.getPriority());
				System.out.println(" thread.isAlive:"+thread.isAlive());
				Thread.sleep(1000);
			}
		} catch (InterruptedException ex){
			System.out.println("Value of exp:"+ex.toString() );
		}
	}
}
