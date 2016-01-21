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
		 int num = 0;
		 int aa=0;
		String file = "C:/Users/yia/Data/T6_N_id.txt";
		String file_1 = "C:/Users/yia/Data/T6_train_id.txt";
		 try{
			 br = new BufferedReader(new FileReader(file));
			 br_1 = new BufferedReader(new FileReader(file_1));
			 String s = null;
			 while((s = br.readLine()) != null){
				 str=s.split("\t");
			 }
			 System.out.println("aaa"+str[1]);
			 while((s = br_1.readLine()) != null){
				  str_1=s.split("\t");
			 }
				 for(int i=0;i<str.length;i++){
					 for(int j=i;j<str_1.length;j++){
						 if(str[i].equals(str_1[j])){
							 aa++;
							 System.out.println(aa);
					 }
						 
				 }
			 }  
			 
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
     }
	}
}
