package Readdatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author yia
 *该文件是对blast 后生成的文件进行提取，仅仅是提取出ID号。
 */
public class Readblastfile {
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = null;
		 int num = 0;
		 String id="";
		 try{
			 String filepath="C:\\Users\\yia\\study\\soft\\Blast\\blast\\db\\blast";
				File file = new File(filepath);
				 if (file.isDirectory()) {     
					 String[] filelist;
					 filelist= new String[file.list().length];
					 filelist=file.list();
					 for (int i = 0; i < filelist.length; i++) { 
						 File readfile = new File(filepath + "\\" + filelist[i]); 
						 if (!readfile.isDirectory())  {
							 br = new BufferedReader(new FileReader(readfile));
							 String s="";
							 while((s = br.readLine()) != null){
								 num++;
								 String[] str = s.split("\\|");
								 id=str[0];//这是数据库 的ID号。
								 System.out.println(id);
								 //System.out.println(str[5]);
								 File out = new File("F:\\yia\\Google Drive\\SecretEPDB\\SqlFile\\Alignment\\orthologs\\" + id + ".txt");
								 FileWriter fw = new FileWriter(out,true);
								 BufferedWriter bw = new BufferedWriter(fw);
								 if(!out.exists())
									{
									  bw.write(str[3]);
									  bw.write("\r\n");
									  bw.flush();
									  System.out.println(str[3]);
									}
								 else{
									 bw.write(str[3]);
									 bw.write("\r\n");
									 bw.flush();
								 }
							 }  	
						 }
		              }
						 }
				 		System.out.println(num);
			 			br.close();
		 }catch(Exception e){     
    	 System.out.println(e);
     }
}
}
