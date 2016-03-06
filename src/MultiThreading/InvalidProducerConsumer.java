package MultiThreading;

class Queue{
	static int value=0;
	
	synchronized int get(){
		System.out.println("GET:: "+value);
		return value;
	}
	
	synchronized void put(int v){
		value = v;
		System.out.println("PUT:: "+value);
	}
}

class Producer implements Runnable{
	Queue queue;
	
	Producer(Queue queue){
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
class Consumer implements Runnable{
	Queue queue;
	
	Consumer(Queue queue){
		this.queue = queue;
		new Thread(this, "Consumer").start();
	}
	
	public void run(){
		while(true){
			queue.get();
		}
	}
}
public class InvalidProducerConsumer {

	public static void main(String[] args) {
		Queue queue = new Queue();
		new Producer(queue);
		new Consumer(queue);
	}
}
