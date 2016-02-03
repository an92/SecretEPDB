import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
/*找到文件的ID号*/
public class Findsame {

	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 BufferedReader br_1 = null;
		 String[] str=null;
		 String[] str_1=null;
		 int aa=0;
		String file = "C:/Users/yia/Google 云端硬盘/Server_Paper/data/T4_full_id.txt";
		String file_1 = "C:/Users/yia/Google 云端硬盘/Server_Paper/data/T4_effpred_N_id.txt";
		File file_2 = new File("C:/Users/yia/Google 云端硬盘/Server_Paper/data/T4_same_N.txt");
		List<String> array = new ArrayList<String>();
		 FileWriter fw = new FileWriter(file_2.getAbsoluteFile(),true);
 		 BufferedWriter bw = new BufferedWriter(fw);
		 try{
			 br = new BufferedReader(new FileReader(file));
			 br_1 = new BufferedReader(new FileReader(file_1));
			 String s = null;
			 while((s = br.readLine()) != null){
				 str=s.split(",");
			 }
			 //System.out.print(str[1]);
			 while((s = br_1.readLine()) != null){
				  str_1=s.split(",");
			 }
			  for(int i=0;i<str.length;i++){
				for(int j=i;j<str_1.length;j++){
					if(str[i].equals(str_1[j])){
							 aa++;
							 i++;
							 //array.add(str[i]);
							System.out.print(aa);
							// System.out.print(str[i]);
							 //System.out.print(str[i]);
					 }
						
				 }
			 }  
				 //System.out.print(aa); 
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     } finally{
	          for(int i=0;i<array.size();i++) 
	        	  bw.write(array.get(i)+',');
			      bw.flush();
	             //System.out.print( + '\r');
			      bw.close();
	     }
	}
}
