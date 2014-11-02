import java.util.UUID;

public class HostRegistration implements Runnable {
	public void run() {	
		UUID hostIDs;
		hostIDs=UUID.randomUUID();	
		System.out.println("Register number for this device is : "+ hostIDs);
	}
}
