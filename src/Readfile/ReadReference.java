package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取文件中的Uniprot Id 或者gi Id 以及Reference的ID。
 *
 */
public class ReadReference {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		
		 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\sql_reference.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\Secretepdb_order.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 String name="";
				 String reference="";
				 if(s.startsWith(">tr")|| s.startsWith(">sp")){
					 String ss[]=s.split("\\|");
					 name=ss[1];
					 System.out.println(name);
					 reference = ss[3];
				 }
				 else if(s.startsWith(">gi")){
					 String ss[]=s.split("\\|");
					 name=ss[1];
					 reference = ss[5];
				 }
				 bw.write(name+","+reference+"\n");
				 bw.flush(); 
				 }
			
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}