package Runcmd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author yia
 *使用java程序运行cmd程序
 */
public class RunBlast {
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
		  String filepath="C:/Users/yia/study/soft/Blast/blast/db/sql_fasta/";	
		  String filepath_blast="C:/Users/yia/study/soft/Blast/blast/db/blast/";
		  File file = new File(filepath);
		  String name="";
		  if (file.isDirectory()) {     
              String[] filelist;
              filelist= new String[file.list().length];
              filelist=file.list();
              for (int i = 0; i < filelist.length; i++) {     
            	  File readfile = new File(filepath + "\\" + filelist[i]);
            	  if (!readfile.isDirectory())  {
                 	 String ss=readfile.getName();                        	 
                 	 name=ss.substring(0, ss.indexOf("."));
                 	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                 	 System.out.println(readfile);
                 	 System.out.println(name);
                 	 String s = null;
                 	 while((s = br.readLine()) != null){     
            	  	String dir="cmd /c C:\\Users/yia/study/soft/Blast/blast/bin/blastall.exe -p blastp -i "+readfile+" -d C:\\Users/yia/study/soft/Blast/blast/db/uniprot_sprot.fasta -e 0.0001 -m 8 -o "+filepath_blast+name+".txt";
            	  	openExe(dir);
            	  	System.out.println(dir);
                 	 }
            	  }
              }
	  }
	  }
}
