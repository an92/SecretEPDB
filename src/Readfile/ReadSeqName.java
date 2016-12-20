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
		 File file = new File("C:\\Users\\407\\Desktop\\BIBFile\\合并所有工具的训练集\\P.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("C:\\Users\\407\\Desktop\\BIBFile\\合并所有工具的训练集\\T3SE_P.fasta"));
			 String s = null;
			 System.out.print(s);
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 String ss[]=s.split("\\|");
					 String name_seq=ss[0];
					 //bw.write(s+"\n\r");
					 bw.write(name_seq+"\n\r");
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