package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取文件中接下来一行的文件
 *
 */
public class Readnextline {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String ss=null;
		 String seq=null;
		 File file = new File("C:\\Users\\yia\\Google Drive\\BIB\\data\\T6_over_fasta.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T3SE.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 seq=br.readLine();
					 bw.write(seq);
					 bw.newLine();
					 bw.flush();	 
					
				 }
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}