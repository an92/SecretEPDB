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
		String file = "C:/Users/yia/effector_P_id.txt";
		String file_1 = "C:/Users/yia/T4EffPred_P_id.txt";
		/*String file = "C:/Users/yia/11.txt";
		String file_1 = "C:/Users/yia/22.txt";*/
		 try{
			 br = new BufferedReader(new FileReader(file));
			 br_1 = new BufferedReader(new FileReader(file_1));
			 String s = null;
			 while((s = br.readLine()) != null){
				 str=s.split(",");
			 }
			 while((s = br_1.readLine()) != null){
				  str_1=s.split(",");
			 }
			 System.out.println("dsadsdsa");
			// System.out.println(str[0]);
			for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < str_1.length; j++) {
					if (str[i].equals(str_1[j])) {
						aa++;
						// array.add(str[i]);
						// System.out.print(aa);
						System.out.println(str[i]);

					}
				}
			}
			System.out.println(aa);
          br.close();
     }catch(Exception e){  
    	 System.out.println(e);
	}
}
}