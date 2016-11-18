package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取Genome中的注释信息，也就是每一个序列的第一行信息
 *
 */
public class Readannotion {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 File file = new File("F:\\yia\\Google Drive\\Bastion4\\Genome\\SignalP\\SignalP3.0\\MGH78578.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\Bastion4\\Genome\\SignalP\\SignalP3.0\\MGH78578_T4SE_NonSignalP.fasta"));
			 String s = null;
			 System.out.print(s);
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 bw.write(s+"\n\r");
					 bw.flush();
				 }
				 /*else if(s.startsWith(">")){
					 String name_seq=s.substring(1,s.length());
					 bw.write(name_seq+"\r");
					 bw.flush();
				 }*/
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}