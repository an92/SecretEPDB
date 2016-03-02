import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Splitfasta {
	public static void main(String[] args) throws Exception{
	 String filepath="C:/Users/yia/T3/T3_uniprot.fasta";	
	  File file = new File(filepath);
	  String name="";
	  String s=null;
	  String[] str=null;
	  String[] str_1=null;
	  BufferedReader  br = new BufferedReader(new FileReader(file));
	  while((s = br.readLine()) != null){    
		   str=s.split(">");
		   System.out.println(str[1]);
       }
	  System.out.println(str[0]);
	  for(int i=0;i<str.length;i++){
		  str_1=str[i].split("\\|");
		  System.out.println(str_1);
		  //name=str_1[1];
		  File out = new File("C:/Users/yia/T3/Align_T3/" + name + "");
			if(!out.exists())
			{
				System.out.println(out);
				FileWriter fw = new FileWriter(out);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(str[i] );
				bw.flush();
				bw.close();
				fw.close();
			}
	  }
}
}
