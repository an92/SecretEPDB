package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 读取species中相同种类的个数并统计
 *
 */
public class ReadsameSpecies {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 String name=null;
		 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\Os_count.txt");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\OS.txt"));
			 String s = null;
			 int count=0;
			 while((s = br.readLine()) != null){
					 String ss[]=s.split("\r");
					 System.out.print(ss[2]);
					 for (int i=0;i<ss.length;i++){
						 for (int j=0;j<ss.length;j++){
							 if(ss[i].equals(ss[j])){
								 count++;
								 //System.out.print(ss[2]);
								// bw.write(ss[i]+","+count);
								// bw.newLine();
							 }
							 
							 bw.flush();
						 }
						 
					 }
			 }
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	 }
}