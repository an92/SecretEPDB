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
		 File file = new File("C:/Users/yia/Google 云端硬盘/Server_Paper/data/plogo/data/T6_dep_P_50.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 String[] aa=null;
		 try{
			 br = new BufferedReader(new FileReader("C:/Users/yia/Google 云端硬盘/Server_Paper/data/plogo/data/T6_dep_P.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 sequence=br.readLine();
					 String seq=sequence.substring(0,50);
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
