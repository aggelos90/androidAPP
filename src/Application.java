
public class Application {

	public static void main(String[] args) {
		Thread ifMonitoringThread = new Thread(new InterfaceMonitoring(),
				"ifMonitoringThread");
		Thread regThread=new Thread(new HostRegistration(), "regThread");		
		Thread packetMonitoringThread = new Thread(new PacketMonitoring(),
				"packetMonitoringThread");

		Thread shmThread = new Thread(new SharedMemManagement(),
				"shmThread");
		shmThread.start();
		// ----------- mutex.down();
	/*	try {
			ThreadsJobIsDone.waitforsignal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//regThread.start();
		ifMonitoringThread.start(); //to run first thread
		//packetMonitoringThread.start();
	}
}
