package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ay
 *将文件中的指定行写入到新的文件
 */
public class Readline {
		public static void main(String[] args) throws IOException {  
	    	String filepath="F:/Google Drive/T4_N/outacc";
	    	File file_write = new File("F:/Google Drive/T4_N/N.acc");
			 List<String> array = new ArrayList<String>();
			 if (file_write.exists()) {
		      		file_write.delete();
				    file_write.createNewFile();
				   } 
		      	else if(!file_write.exists()){
		      		
		      		file_write.createNewFile();
		      	}
			 FileWriter fw = new FileWriter(file_write.getAbsoluteFile(),true);
	  		 BufferedWriter bw = new BufferedWriter(fw);
	    	 try{
	    		 File file = new File(filepath);
	    		 if (file.isDirectory()) {     
	                 String[] filelist;
	                 filelist= new String[file.list().length];
	                 filelist=file.list();
	                 String[] str;
		             str= new String[58]; 
	                 for (int i = 0; i < filelist.length; i++) {
	                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
							String s = null;
                        	 while((s = br.readLine()) != null){ 
                        		 String ss=br.readLine();
                        		 str[i]=br.readLine();
                        		 array.add(">"+s+"\n"+str[i]);
                        	 }
                         }
	                 }
	    		 }
	    	 }catch(Exception e){
	    		 System.out.println(e);
	    	 	}finally{
	    	          for(int i=0;i<array.size();i++) 
	    	        	  bw.write(array.get(i)+"\n");
	    			      bw.flush();
	    	             //System.out.print( + '\r');
	    			      bw.close();
	    	     }
	    }
	}
