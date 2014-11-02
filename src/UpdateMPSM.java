import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UpdateMPSM implements Runnable{

	public void run() {
		File dir = new File(".");
		File fin;
		ArrayList<String> maliciousIPs = new ArrayList<String>();
		ArrayList<String> maliciousPatterns=new ArrayList<String>();
		try {
			fin = new File(dir.getCanonicalPath() + File.separator
					+ "malicious.txt");
			FileInputStream fis = new FileInputStream(fin);

			// Construct BufferedReader from InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				String[] tokens=line.split(" ");
				maliciousIPs.add(tokens[0]);
				maliciousPatterns.add(tokens[1]);
			}
			br.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
