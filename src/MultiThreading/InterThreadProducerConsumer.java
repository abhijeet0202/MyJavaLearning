package MultiThreading;

class ValidQueue{
	int value;
	boolean valueSet = false;

	synchronized int get(){
		while (!valueSet){
			try{
				wait();
			}catch (InterruptedException ex){
				System.out.println(ex);
			}
		}

		System.out.println("GET:: "+value);
		valueSet = false;
		notify();
		/*try{
		Thread.sleep(10);
		} catch (InterruptedException ex){
				System.out.println(ex);
			}*/
		return value;
	}

	synchronized void put(int v){
		while (valueSet){
			try{
				wait();
			} catch (InterruptedException ex){
				System.out.println(ex);
			}
		}
		value = v;
		System.out.println("PUT:: "+value);
		valueSet = true;
		notify();
		/*try{
			Thread.sleep(10);
			} catch (InterruptedException ex){
					System.out.println(ex);
				}*/
	}
}

class ValidProducer implements Runnable{
	ValidQueue queue;

	ValidProducer(ValidQueue queue){
		this.queue = queue;
		new Thread(this, "Producer").start();
	}

	public void run(){
		int i =0;
		while(true){
			queue.put(++i);
		}
	}
}
class ValidConsumer implements Runnable{
	ValidQueue queue;

	ValidConsumer(ValidQueue queue){
		this.queue = queue;
		new Thread(this, "Consumer").start();
	}

	public void run(){
		while(true){
			queue.get();
		}
	}
}
public class InterThreadProducerConsumer {

	public static void main(String[] args) {
		ValidQueue queue = new ValidQueue();
		new ValidProducer(queue);
		new ValidConsumer(queue);
	}
}
