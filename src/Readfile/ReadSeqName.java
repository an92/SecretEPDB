package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取文件种的Sequence的名称
 *
 */
public class ReadSeqName {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 String name=null;
		 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T4SE\\4370_seq.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T4SE\\4370.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 String ss[]=s.split("\\|");
					 String name_seq=ss[1];
					 bw.write(name_seq+"\r");
					 bw.flush();
					 
					/* name=s.substring(1,s.length());
					 bw.write(name+",");
					 //bw.newLine();
					 bw.flush();*/	 
					
				 }
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}