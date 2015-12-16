import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FindAlignment {

	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		
		int line = 0;
		String filename="C:/Users/yia/study/soft/Blast/blast/db/text.txt";
		String filepath="C:/Users/yia/Data/Alignment_seq_id/";
		 
		try {
			br = new BufferedReader(new FileReader(filename));
			String id="sss";
			String s = null;
			String strs = "";
			while ((s = br.readLine()) != null) {
				File out = new File(filepath + id + ".txt");
				FileWriter fw = new FileWriter(out);
				BufferedWriter bw = new BufferedWriter(fw);
				if (s.startsWith("sp")) {
					String[] str=s.split("\\|");
					bw.write(str[3]);
					bw.flush();
				}
				}
			System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
