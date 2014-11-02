import java.util.concurrent.ConcurrentHashMap;

public class SharedMemory {
	static MPSM mpsm;
	static ConcurrentHashMap<String, S_MPSM> s_mpsm;

	public static void print() {
		// TODO Auto-generated method stub
		
		mpsm.addMaliciousIps("12.4.5.5.1");
		mpsm.addMaliciousIps("12.4.5.5.3");
		mpsm.addMaliciousIps("12.4.5.5.2");
		
		mpsm.addMaliciousPatterns("http111");
		mpsm.addMaliciousPatterns("http");
		mpsm.addMaliciousPatterns("http23");
		
		System.out
				.println("-----------------Shared Memory : MPSMP ------------------------");
		mpsm.print();
		System.out
				.println("-----------------Shared Memory : S_MPSMP ------------------------");
		for (String ifName : s_mpsm.keySet()) {
			S_MPSM smpsmObject = s_mpsm.get(ifName);
			smpsmObject.print();		
		}
	}

}
