package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 * 通过序列的名称找到重复的序列名称
 *
 */
public class FindReduant {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T4SE\\T4SE_1.fasta");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T4SE\\T4SE.fasta"));
			 String s = null;
			 String ss[]=null;
			 String count[] = new String[1216];
			 String next = null;
			 for (int i=0;i<1216;i++){
				 while((s = br.readLine()) != null){
					 if(s.startsWith(">")){
						 ss=s.split("\\|");
						 next =br.readLine();
						 count[i] = ss[1];
				 		}
					 while(!count[i].equals(ss[1])){
							bw.write(s+'\n');
							bw.write(next+'\n');
							  }
						  }
					  }
         br.close();
     }catch(Exception e){ ;
    	 System.out.println(e);
     }
	 }
}