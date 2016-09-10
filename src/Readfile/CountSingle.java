
package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author yia
 * 统计氨基酸的出现次数
 *
 */
public class CountSingle {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 /*String ss=null;
		 String seq=null;
		File file = new File("F:/Google Drive/control-seq.fasta");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		try{
			 br = new BufferedReader(new FileReader("F:/Google Drive/control.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 seq=br.readLine();
					 bw.write(seq);
					 //bw.newLine();
					 bw.flush();	 
					
				 }
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }*/
		 File file = new File("F:/Google Drive/control-length.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String filename="F:/Google Drive/control-seq.fasta";
		 bw.write(String.valueOf(count(filename, "A")));
		 bw.newLine();
		 bw.flush();
		 bw.write(String.valueOf(count(filename, "R")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "N")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "D")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "C")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "Q")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "E")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "G")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "H")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "I")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "L")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "K")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "M")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "F")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "P")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "S")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "T")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "W")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "Y")));
		 bw.newLine();
		 bw.write(String.valueOf(count(filename, "V")));
		 bw.newLine();
		 bw.flush();
	 }

public static int count(String filename, String target)   throws FileNotFoundException, IOException {  
		    FileReader fr = new FileReader(filename);  
		    BufferedReader br = new BufferedReader(fr);  
		    StringBuilder strb = new StringBuilder();  
		    while (true) {  
		     String line = br.readLine();  
		     if (line == null) {  
		      break;  
		     }  
		     strb.append(line);  
		    }  
		    String result = strb.toString();  
		    int count = 0;  
		    int index = 0;  
		    while (true) {  
		     index = result.indexOf(target, index + 1);  
		     if (index > 0) {  
		      count++;  
		     } else {  
		      break;  
		     }  
		    }  
		    br.close();  
		    return count;  
		   }  
		    
	}

