package delsame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

public class Readfile {
	public static void main(String[] args) throws Exception {
//		File file1 = new File("C:\\Users\\leix\\1.txt");
//		File file2 = new File("C:\\Users\\leix\\2.txt");
		File file1 = new File("C:\\Users\\leix\\test\\trainging_set.fasta");
		File file2 = new File("C:\\Users\\leix\\test\\T6_N.fasta");
		read(file1,file2);
	}
	
	@SuppressWarnings("resource")
	public static void read(File f1,File f2) throws Exception {
		BufferedReader in1,in2;
		PrintStream out;
		String id;
		String[] text1,text2;
		String line1, line2;
		HashMap<String, String> texts;
		int i=0,j=0;
		 out = new PrintStream(new
		 FileOutputStream("C:\\Users\\leix\\4.txt"));
		try {
			in1 = new BufferedReader(new FileReader(f1));
			in2 = new BufferedReader(new FileReader(f2));
			while ((line1 = in1.readLine()) != null) {
				i++;
			}
			while ((line2 = in2.readLine()) != null) {
				j++;
			}
			text1 = new String[i];
			text2 = new String[j];
			i=0;
			j=0;
			in1 = new BufferedReader(new FileReader(f1));
			in2 = new BufferedReader(new FileReader(f2));
			while ((line1 = in1.readLine()) != null) {
				text1[i] = line1;
				i++;
			}
			while ((line2 = in2.readLine()) != null) {
				text2[j] = line2;
				j++;
			}
			for (j = 0; j < text2.length; j++) {
				for (i = 0; i < text1.length; i++) {
					if(text2[j].equals(text1[i]))
						j++;
				}if(j<text2.length)
					out.println(text2[j]);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
