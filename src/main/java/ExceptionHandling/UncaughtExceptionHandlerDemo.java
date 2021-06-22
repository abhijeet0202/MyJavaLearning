package ExceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerDemo implements UncaughtExceptionHandler
{
	public static int i=0;
	   public void uncaughtException(Thread t, Throwable e)
	   {
		   i++;
	      System.out.printf("An exception has been captured\n");
	      System.out.printf("Thread: %s\n", t.getId());
	      System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
	      System.out.printf("Stack Trace: \n");
	      e.printStackTrace(System.out);
	      System.out.printf("Thread status: %s\n", t.getState());
	      if(i <2)
	    	  new Thread(new Task()).start();
	      
	   }
	public static void main(String[] args) {
		new Thread(new Task()).start();

	}

}
class Task implements Runnable
{
   @Override
   public void run()
   {
      Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandlerDemo());
      System.out.println(Integer.parseInt("123"));
      System.out.println(Integer.parseInt("234"));
      System.out.println(Integer.parseInt("345"));
      System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
      System.out.println(Integer.parseInt("456"));
   }
}