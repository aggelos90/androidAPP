import java.util.concurrent.ConcurrentHashMap;

public class SharedMemManagement implements Runnable {
	
	public void run() {
		SharedMemory.mpsm=new MPSM();
		SharedMemory.s_mpsm=new ConcurrentHashMap<String, S_MPSM>();
		System.out.println("Shared Memory has been successfully created");
		ThreadsJobIsDone.release();
		while(true){
			//ektupwsh mnhmwn
			try {
				Thread.sleep(10000);
				System.out.println("------- Shared Memory ----");
				SharedMemory.print();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
