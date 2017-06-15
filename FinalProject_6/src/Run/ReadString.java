package Run;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadString {
	public static String loadFile(String path) {
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
				String line;
				while((line=br.readLine())!= null){
					sb.append(line+"\n");
				}
				br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static int parseInt(String number) {
		return Integer.parseInt(number);
	}
}
