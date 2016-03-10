package Readdatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 *该文件是对blast 后生成的文件进行提取，identity>0.8后对相同的querey 的balst的序列进行提取。
 */
public class Readblastfile {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int num = 0;
		 String id="";
		 try{
			 br = new BufferedReader(new FileReader("C:\\Users\\yia\\Clustal\\all_fasta_blast.txt"));
			 String s = null;
			 while((s = br.readLine()) != null){
					 num++;
					 String[] str = s.split("\\|");
					 id=str[0];//这是数据库 的ID号。
					 System.out.println(id);
					 //System.out.println(str[5]);
					 File out = new File("C:\\Users\\yia\\Clustal\\Aln\\" + id + ".txt");
					 FileWriter fw = new FileWriter(out,true);
					 BufferedWriter bw = new BufferedWriter(fw);
					 if(!out.exists())
						{
						  bw.write(str[3]);
						  bw.write("\r\n");
						  bw.flush();
						  System.out.println(str[3]);
						}
					 else{
						 bw.write(str[3]);
						 bw.write("\r\n");
						 bw.flush();
					 }
			 }  
				 		System.out.println(num);
			 			br.close();
		 }catch(Exception e){     
    	 System.out.println(e);
     }
}
}
