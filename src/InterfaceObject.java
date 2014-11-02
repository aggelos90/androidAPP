import java.util.HashMap;


public class InterfaceObject {
	public String interfaceName;
	public String interfaceIP;
	public HashMap ipFrequencyMap;
	public HashMap patternFrequencyMap;

	public InterfaceObject(String interfaceName, String interfaceIP) {
		super();
		this.interfaceName = interfaceName;
		this.interfaceIP = interfaceIP;
		ipFrequencyMap=null;
		patternFrequencyMap=null;
	}
}