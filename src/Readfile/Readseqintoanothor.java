package Readfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取 T4SE_joint 的相关性
 */
public class Readseqintoanothor {
	public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String sequence=null;
		 String seq=null;
		 File file = new File("C:/Users/yia/Google Drive/BIB/data/T4SE/new_table/T4_P.acc");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("C:/Users/yia/Google Drive/BIB/data/T4SE/new_table/joint/T4_CD-hit-P.acc"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 seq=br.readLine();
					 bw.write(">Seq"+m);
					 bw.newLine();
					 bw.write(seq);
					 bw.newLine();
					 bw.flush();	
					 m++;
				 }
				 }
         br.close();
    }catch(Exception e){  
   	 System.out.println(e);
    }
	}
}
