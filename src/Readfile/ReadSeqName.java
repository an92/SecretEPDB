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
		 File file = new File("F:\\Google Drive\\SecretEPDB\\NewData\\T3SE\\24391954(T3SP)_seq.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\Google Drive\\SecretEPDB\\NewData\\T3SE\\24391954(T3SP).fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 name=s.substring(1,s.length());
					 bw.write(name+",");
					 //bw.newLine();
					 bw.flush();	 
					
				 }
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}