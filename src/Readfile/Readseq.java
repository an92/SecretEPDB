package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 按照固定的长度截取sequence长度，多行。
 *
 */
public class Readseq {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String sequence=null;
		 String seq=null;
		 File file = new File("C:/Users/yia/Google 云端硬盘/Server_Paper/data/depedent dataset/T3_dep_N_100.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("C:/Users/yia/Google 云端硬盘/Server_Paper/data/depedent dataset/T3_dep_N.txt"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 seq=br.readLine();
					 int n=seq.length();
					 sequence=br.readLine();
					 if(sequence.length()>=40){
							seq+=sequence.substring(0,100-n).replaceAll(" +","");//去掉所有空格   ;
					  }
						 else{
							 seq+=sequence.replaceAll(" +","");
						 }
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
