import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MPSM {
	
	private Set<String> maliciousIps; 
	private Set<String> maliciousPatterns; 

	public MPSM() {
		maliciousIps = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
		maliciousPatterns=Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
		}

	public Set<String> getMaliciousIps() {
		return maliciousIps;
	}

	public void setMaliciousIps(Set<String> maliciousIps) {
		this.maliciousIps = maliciousIps;
	}
	
	public void addMaliciousIps(String ip){
		maliciousIps.add(ip);
	}
	
	public void addMaliciousPatterns(String pattern){
		maliciousPatterns.add(pattern);
	}

	public Set<String> getMaliciousPatterns() {
		return maliciousPatterns;
	}

	public void setMaliciousPatterns(Set<String> maliciousPatterns) {
		this.maliciousPatterns = maliciousPatterns;
	}
	public void print(){
		System.out.println("\n\t Malicious Ips ");
		for (String ip : maliciousIps) {
			System.out.println("\t" + ip);
		}
		System.out.println("\n\t Malicious Patterns ");
		for (String pattern : maliciousPatterns) {
			System.out.println("\t" + pattern);
		}
	}
}
