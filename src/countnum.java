import java.io.BufferedReader;
import java.io.FileReader;
/*找到文件的ID号*/
public class countnum {

	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int num = 0;
		 try{
			 br = new BufferedReader(new FileReader("C:/Users/yia/T4_new_dep.fasta"));
			 
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 num++;
					 String[] str = s.split("\\|");
				 }
			 }  
			 System.out.println(num);
          br.close();
     }catch(Exception e){       
	}
}
}