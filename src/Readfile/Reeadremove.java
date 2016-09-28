package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取species中相同种类的个数并统计
 *
 */
public class Reeadremove {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 String name=null;
		 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\Secre_2.fasta");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\Secretepdb_order_1.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
					 String ss=s.replaceAll("\r","\r\n");
					 bw.write(ss);
					 bw.flush();
						 
			 }
			 br.close();
						 
          
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}