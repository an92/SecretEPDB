package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 计算AAP文件
 *
 */
public class CountAAP {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 int j=0;
		 String ss=null;
		 String seq=null;
		 String flag=null;
		 File file = new File("C:\\Users\\yia\\Google Drive\\T3_AAP.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("C:\\Users\\yia\\Google Drive\\Text.txt"));
			 String s = null;
			 while((s = br.readLine()) != null){
				     String str[] = s.split("\t");
				     flag=str[2];
					 String seq_1[] = br.readLine().split("\t");
					 if(flag.equals(seq_1[2])){
						 j=Integer.parseInt(str[3])+Integer.parseInt(seq_1[3]);
					 }
					 bw.write(flag+","+j);
					 bw.newLine();
					 bw.flush();	 
					
				 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}