package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读出每个序列的长度,不分正负样本
 *
 */
public class CountLengthAll {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String ss=null;
		 String seq=null;
		 File file = new File("F:/Google Drive/control.csv");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 int n=0;
		 try{
			 br = new BufferedReader(new FileReader("F:/Google Drive/control.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">") ){
					 seq=br.readLine();
					 n=seq.length();
					 ss = "Length,"+n;
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
