
public class ThreadsJobIsDone {
	private static Object lock= new Object();
	private static Boolean bool=false;
	public static void waitforsignal() throws InterruptedException{
        synchronized(lock){
             	while (bool==false) {
             		System.out.println("Waiting for signal!");
                    lock.wait();
                }
        }
	}
	public static void release() {
        synchronized(lock){
        		bool=true;
        		System.out.println("About to send a signal!");
                lock.notify();
        }
	}
}
