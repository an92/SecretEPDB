import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
/*找到fasta文件的ID号*/
public class FindID {

	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int num = 0;
		 File file = new File("C:/Users/yia/Data/T3data/T3_blast_noreduant.txt");
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
			 br = new BufferedReader(new FileReader("C:/Users/yia/Data/T3data/T3_blast_noreduant.fasta"));
			 
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">tr")||s.startsWith(">sp")){
					 num++;
					 String[] str = s.split("\\|");
					 //System.out.println(str[1]);
					 array.add(str[1]);
				 }
			 }           
          br.close();
     }catch(Exception e){       
     }finally{
          for(int i=0;i<array.size();i++) 
        	  bw.write(array.get(i)+'\t');
              bw.newLine();bw.newLine();
          	  bw.write("共计有"+num+"个"); 
		      bw.flush();
             //System.out.print( + '\r');
		      bw.close();
     }
	}
}
