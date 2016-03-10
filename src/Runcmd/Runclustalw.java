package Runcmd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;


public class Runclustalw {
	 public static  void openExe(String dir) {
		  Runtime rn = Runtime.getRuntime();
		  try {
		   Process p=rn.exec(dir);
		   if (p.waitFor() != 0) {
		        if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束     
		            System.err.println("命令执行失败!"); 
		   }
		  } catch (Exception e) {
		   System.out.println("Error!"+e);
		  }
		 }
	  public static void main(String[] args) throws SQLException, IOException { 
		  BufferedReader br = null;
		  String filepath="C:\\Users\\yia\\Clustal\\Aln_fasta\\";	
		  //String path="C:\\Users/yia/study/soft/Blast/blast/db";
		  String filepath_blast="C:/Users/yia/Clustal/Aln_clustalw/";
		  File file = new File(filepath);
		  String name="";
		  int num=0;
		  if (file.isDirectory()) {     
              String[] filelist;
              String s=null;
              filelist= new String[file.list().length];
              filelist=file.list();
              for (int i = 0; i < filelist.length; i++) {     
            	  File readfile = new File(filepath + "\\" + filelist[i]);
            	  br = new BufferedReader(new FileReader(readfile));
            	  if (!readfile.isDirectory())  {
            		  while((s = br.readLine()) != null){
         				 if(s.startsWith(">")){
         					 num++;
         				 }
         			 }  
            		  if(num>1){
            			  String ss=readfile.getName();                        	 
                      	  name=ss.substring(0, ss.indexOf("."));
                      	  System.out.println(readfile);
                      	  System.out.println(name);
                 	  	  String dir="cmd /c C:\\Users/yia/Downloads/clustal-omega-1.2.0-win32/clustalo.exe -i "+readfile+" -t protein --outfmt=clu -o "+filepath_blast+name+".aln";
                 	      openExe(dir);
                 	  	 System.out.println(dir);
                 	 }
            	  }
              }
	  }
	  }
}
