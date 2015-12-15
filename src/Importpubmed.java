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

/*将pubmed数据读取到数据库中*/
public class Importpubmed {

	public static void main(String[] args) throws Exception {
		 String driver = "com.mysql.jdbc.Driver";
 	    String url = "jdbc:mysql://localhost:3306/secretepdb";
 	    String username = "root";
 	    String password = "admin";
 	    Connection conn = null;
 	    Statement stmt = null;  	    
		String seq = "";
		String length="";
		String name="";
		 String sql="";
 	     String names="";
	     String molecalarweight="";
	     String alt="";
	     String organism="";
	     String gene="";
	     String function="";
	     String uniprotId="";
		BufferedReader br = null;
		int line = 0;
		String filename="C:/Users/yia/Data/Pubmed/T3_Pubmed.fasta";
		 try {       
  		   Class.forName(driver);    
  		   conn = DriverManager.getConnection(url, username, password);
  		   stmt = conn.createStatement();
             System.out.println("yes");
       } catch (Exception e) {
           System.out.print("MYSQL ERROR:" + e.getMessage());
       }
		try {
			br = new BufferedReader(new FileReader(filename));
			String s = null;
			String strs = "";
			String[] strss=new String[1];
			while ((s = br.readLine()) != null) {
				if (s.startsWith(">")) {
					line++;
				}
				}
			System.out.println(line);
 			strss = new String[line];
			line=0;
			br = new BufferedReader(new FileReader(filename));
			while ((s = br.readLine()) != null) {
				if (s.startsWith(">")) {
					strss[line] = strs;
					strs = "";
					strs = s;
					line++;
				} else
					strs += s;
			}
			for(int j=1;j<line;j++){
				//System.out.println(strss[j]);
				int length_1=0;
				String[] ss=strss[j].split("\\|");
				seq=ss[7];//sequence
				//System.out.println(seq);
				char[] ch = ss[7].toCharArray();
				for (int mm = 0; mm< ch.length; mm++) {
		            if (Character.isLetter(ch[mm])) {
		                // 判断是否为字母
		                length_1++;
		            }
				}
				name=ss[4].substring(0, ss[4].indexOf("["));//name
				length= Integer.toString(length_1);
				System.out.println(name);
				System.out.println(j);
				System.out.println(length);
				/*sql = "insert into protein(UniprotID,Name,Evidence,MolecularWeight,Function,Sequence,Length,altUniprotACC,DBid,Organism,Gene,allNames,flagType)values"
  						+ "(\""+ uniprotId +"\",\""+name+"\",\"\",\""+molecalarweight+"\",\""+function+"\",\""+seq+"\",\""+length+"\",\""+alt+"\",\"\",\""+organism+"\",\""+gene+"\",\""+names+"\",\"T4_paper_NCBI\")";
  				stmt.execute(sql);*/
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
