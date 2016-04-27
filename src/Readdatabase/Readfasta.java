package Readdatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
/*找到文件的ID号*/
public class Readfasta {

	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int num = 0;
		File file = new File("C:/Users/yia/Google Drive/BIB/data/plogo/15.4/4_ID.txt");
		 List<String> array = new ArrayList<String>();
		 if (file.exists()) {
	      		file.delete();
			    file.createNewFile();
			   } 
	      	else if(!file.exists()){
	      		
	      		file.createNewFile();
	      	}
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
  		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader("C:/Users/yia/Google Drive/BIB/data/depedent dataset/T4/T4_new_dep_P.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 num++;
					 String[] str = s.split("\\|");
					 //System.out.println(str[1]);
					 array.add(str[1]);
				 }
			 }  
			 System.out.println(num);
          br.close();
     }catch(Exception e){       
     }finally{
          for(int i=0;i<array.size();i++) 
        	  bw.write(array.get(i)+',');
		      bw.flush();
             //System.out.print( + '\r');
		      bw.close();
     }
	}
}
