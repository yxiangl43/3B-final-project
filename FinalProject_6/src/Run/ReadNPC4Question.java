package Run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadNPC4Question {
	public static void loadFile(String path, String question[][], String answer[]) {

		try {
			Scanner in = new Scanner(new File(path));
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					
					String questions = in.nextLine();
					if(j == 0 ){
						answer[i] = questions;
					}
					question[i][j] = questions;
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
