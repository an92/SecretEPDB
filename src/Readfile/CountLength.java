package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读出每个序列的长度
 *
 */
public class CountLength {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String ss=null;
		 String seq=null;
		 File file = new File("F:/T6_p.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("F:/T6_1.fasta"));
			 String s = null;
			 /*while((s = br.readLine()) != null){
				 if(s.startsWith(">") & s.endsWith("|1|")){
					 seq=br.readLine();
					 int n=seq.length();
					 ss="Positive,"+n;
				 }
				 else if(s.startsWith(">") & s.endsWith("|-1|")){
					 seq=br.readLine();
					 int n=seq.length();
					 ss="Negative,"+n;
				 }
					 bw.write(ss);
					 bw.newLine();
					 bw.flush();	 
					
				 }*/
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 seq=br.readLine();
					 int n=seq.length();
					 ss="Positive,"+n;
				 }
				 bw.write(ss);
				 bw.newLine();
				 bw.flush();	
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	}
}
