import java.util.ArrayList;
import java.util.List;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.Payload;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.network.Ip4;

public class PacketMonitoring implements Runnable {

	public void run() {
		// Sip sipHeader = new Sip();
		// Udp udpHeader = new Udp();
		// Tcp tcpHeader = new Tcp();int snaplen = 64 * 1024; // Capture all
		// packets, no trucation
		List<PcapIf> alldevs = new ArrayList<PcapIf>(); // Will be filled with
														// NICs
		StringBuilder errbuf = new StringBuilder(); // For any error msgs

		/***************************************************************************
		 * First get a list of devices on this system
		 **************************************************************************/
		int r = Pcap.findAllDevs(alldevs, errbuf);
		if (r == Pcap.NOT_OK || alldevs.isEmpty()) {
			System.err.printf("Can't read list of devices, error is %s",
					errbuf.toString());
			return;
		}
		PcapIf device = alldevs.get(4); // We know we have atleast 1 device
		System.out.printf("\nChoosing '%s' on your behalf:\n",
				(device.getDescription() != null) ? device.getDescription()
						: device.getName());

		int snaplen = 64 * 1024; // Capture all packets, no trucation
		int flags = Pcap.MODE_PROMISCUOUS; // capture all packets
		int timeout = 10 * 1000; // 10 seconds in millis
		Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout,
				errbuf);

		if (pcap == null) {
			System.err.printf("Error while opening device for capture: "
					+ errbuf.toString());
			return;
		}

		PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

			public void nextPacket(PcapPacket packet, String user) {
				Ip4 ip = new Ip4();
				byte[] dIP = new byte[4], sIP = new byte[4];
				if (packet.hasHeader(ip)) {
					dIP = packet.getHeader(ip).destination();
					sIP = packet.getHeader(ip).source();
				} else {
					return;
				}
				String sipMessage = null;
				Payload payloadHeader = new Payload();
				if (packet.hasHeader(payloadHeader)) {
					System.out.println("mpika");
					JBuffer payload = payloadHeader;
					sipMessage = payload.getUTF8String(0, payload.size());
					if (sipMessage.contains("http") || sipMessage.contains("HTTP") || sipMessage.contains("hosts") || sipMessage.contains("man")) {
						System.out.println(sipMessage);
						System.out.println("nai to brhka");
//						System.exit(0);
					}
				}
				String sourceIP = org.jnetpcap.packet.format.FormatUtils
						.ip(sIP);
				String destinationIP = org.jnetpcap.packet.format.FormatUtils
						.ip(dIP);
				System.out.println("Received packet :\n\tSource IP : "
						+ sourceIP + "\n\tDestination IP : " + destinationIP
						+ "\n\tPayload : " + sipMessage);
			}
		};
		pcap.loop(-2, jpacketHandler,null);
		pcap.close();
		System.out.println("jNetPcap session closed");
	}
}
