package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 从fasta文件中读取到bacterial species.
 *
 */
public class ReadSpecies {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String sequence=null;
		 File file = new File("C:\\Users\\yia\\species.csv");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 String[] bb=null;
		 try{
			 br = new BufferedReader(new FileReader("C:\\Users\\yia\\111.txt"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">gi")){
					 aa=s.split("\\|");
					 //sequence=br.readLine();
//					 int length=sequence.length();
					 String sp=aa[4].substring(aa[4].indexOf("["));					
					 bw.write(sp);
					 bw.newLine();
					 bw.flush();
				 }
				 else if(s.startsWith(">sp")||s.startsWith(">tr")){
					 bb=s.split("\\|");
					 //sequence=br.readLine();
//					 int length=sequence.length();
					 String sp=bb[2].substring(bb[2].indexOf("="));					
					 bw.write(sp);
					 bw.newLine();
					 bw.flush();
				 }
			 }
			 /*if(s.startsWith(" ")){
         		sequence+=s;                            		                        		                  		
                 sequence = sequence.replaceAll(" +","");//去掉所有空格             			
         		}*/
			 
          br.close();
     }catch(Exception e){       
     }/*finally{
          for(int i=0;i<array.size();i++) 
        	  bw.write(array.get(i)+'\t');
              bw.newLine();bw.newLine();
          	  bw.write("共计有"+num+"个"); 
		      bw.flush();
             //System.out.print( + '\r');
		      bw.close();
     }*/
	}


}
