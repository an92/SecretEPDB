package Readdatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 按照固定的长度截取sequence长度50个序列，（一行）。
 *
 */
public class Readsequence {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int m = 0;
		 String sequence=null;
		 File file = new File("C:\\Users\\yia\\Google 云端硬盘\\Server_Paper\\data\\database_data\\T3\\all_T3_C_50.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("C:\\Users\\yia\\Google 云端硬盘\\Server_Paper\\data\\database_data\\T3\\all_T3.txt"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 sequence=br.readLine();
					 int length=sequence.length();
					 String seq=sequence.substring(length-50,length);
					 //String seq=sequence.substring(0,50);
					 bw.write(seq);
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