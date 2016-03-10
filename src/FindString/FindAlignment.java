package FindString;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



public class FindAlignment {

	public static void main(String[] args) throws Exception {
		int line = 0;
		String filepath="C:/Users/yia/Data/Align/T6/";
		String filepath_align="C:/Users/yia/Data/Align/T6_Align/";
		try{
   		 File file = new File(filepath);
   		 System.out.println(file.list().length);
   		 if (file.isDirectory()) {     
                String[] filelist;
                filelist= new String[file.list().length];
                filelist=file.list();
                for (int i = 0; i < filelist.length; i++) { 
                	String id="";
                 	File readfile = new File(filepath + "\\" + filelist[i]);                         
                    if (!readfile.isDirectory())  {
                       	 String ss=readfile.getName();                        	 
                       	 id=ss.substring(0, ss.indexOf("."));
                       	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                       	 String s = null;
                       	 while((s = br.readLine()) != null){    
                       		File out = new File(filepath_align + id + ".txt");
                          	 FileWriter fw = new FileWriter(out,true);
                          	 BufferedWriter bw = new BufferedWriter(fw);
                          	 if (s.startsWith("sp")) {
            					String[] str=s.split("\\|");
            					/*System.out.println("ddd");
            					System.out.println(str[3]);*/
            					//bw.write(id);
            					bw.write(str[3]);
            					bw.newLine();
            					bw.flush();
            				 	bw.close();
            				}
            				}
                       	 }
                }
   		 }
		}catch(Exception e){
   		 System.out.println(e);
   	 	}
	}
}
