import java.util.HashMap;

public class S_MPSM {
	//private String interfaceName;
	private String interfaceIP;
	private HashMap<String, Integer> ipFrequencyMap;
	private HashMap<String, Integer> patternFrequencyMap;

	public S_MPSM() {
		//interfaceName = null;
		interfaceIP = null;
		ipFrequencyMap = new HashMap<String, Integer>();
		patternFrequencyMap = new HashMap<String, Integer>();
	}

	public S_MPSM(String interfaceIP) {
		super();
		this.interfaceIP = interfaceIP;
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}
}