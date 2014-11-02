import java.util.ArrayList;
import java.util.List;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

public class InterfaceMonitoring implements Runnable {

	public void run() {
		int i = 1;
		List<PcapIf> netInterfaces = new ArrayList<PcapIf>(); // Get all NICS
		StringBuilder errbuffer = new StringBuilder(); // Buffer that is used
		int currentSize = 0,previousSize;
		findNetworkInterfaces(netInterfaces, errbuffer);  // Wrapper for findAlldevices
		currentSize = netInterfaces.size();

		while (true) {
			previousSize=currentSize;
			currentSize = netInterfaces.size();
			if (currentSize != previousSize) {
				System.out.println("Change occured in interfaces!");
				if (previousSize < currentSize) {
					//dhmiourgia neou nhmatos
					System.out.println("New interface was detected!"+"Sum of interfaces : "+ currentSize);
				}
				else {
				//	katastrofh nhmatos
					System.out.println("Existing interface was removed!"+"Sum of interfaces : "+ currentSize);
				}
				for (PcapIf dev : netInterfaces) {
					System.out.println("[" + (i++) + "] : " + dev.getName());
				}
				i=1;
				previousSize=currentSize;
			}
			netInterfaces.clear();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			findNetworkInterfaces(netInterfaces, errbuffer);  // Wrapper for findAlldevices
		}
	}

	private void findNetworkInterfaces(List<PcapIf> netInterfaces,
			StringBuilder errbuffer) {
		int result;
		result = Pcap.findAllDevs(netInterfaces, errbuffer);
		if (result == Pcap.NOT_OK || netInterfaces.isEmpty()) {
			System.err.printf(
					"No devices are available at this moment, error is %s",
					errbuffer.toString());
			System.exit(0);
		}
	}
}
