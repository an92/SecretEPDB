import java.io.BufferedReader;
import java.io.FileReader;
/*数序列的个数*/
public class countnum {

	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int num = 0;
		 try{
			 br = new BufferedReader(new FileReader("C:/Users/yia/Google 云端硬盘/Server_Paper/data/dabase_data/T4/T4_NCBi.fasta"));
			 
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
