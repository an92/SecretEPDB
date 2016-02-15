import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yia
 *根据Uniprot的注释提取时间信息
 */
public class FindDT {
    public static void main(String[] args) throws IOException {       
    	    String filepath="C:/Users/yia/Google 云端硬盘/Server_Paper/data/depedent dataset/uniprot/";
    	    File file_1 = new File("C:/Users/yia/Google 云端硬盘/Server_Paper/data/depedent dataset/T4_dep_P_DT.txt");
   		  List<String> array = new ArrayList<String>();
   		  if (file_1.exists()) {
   			file_1.delete();
   			file_1.createNewFile();
   			   } 
   	       	else if(!file_1.exists()){
   	      		
   	       	file_1.createNewFile();
   	      	}
   		  FileWriter fw = new FileWriter(file_1.getAbsoluteFile(),true);
     		 BufferedWriter bw = new BufferedWriter(fw);
    	 try{
    		 File file = new File(filepath);
    		 System.out.println(file.list().length);
    		 if (file.isDirectory()) {     
                 String[] filelist;
                 filelist= new String[file.list().length];
                 filelist=file.list();
                 for (int i = 0; i < filelist.length; i++) {               	
                	 String sequence="";    
             	     String names="";
             	     String name="";
            	     String uniprotId="";
            	     String function1="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 String ss=readfile.getName();                        	 
                        	 uniprotId=ss.substring(0, ss.indexOf("."));;//表Protein中UniprotID
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 boolean isName = true;
                        	 String s = null;
                        	 while((s = br.readLine()) != null){               	  
                            	 if(s.startsWith("DT")){ 
                            		 String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                            		 String[] name1 = qq.split("\\*");   
                            		 String name2=name1[1];
                            		 if(isName){                   			
                            			 name=s;                      		 
                                 		 isName = false;
                            		 }                            		                        		                     			
                                		 names=names+s+";";            		                       		                     			                        		                  		 
                            	}                 	  
                            	} 
                         }
                         array.add(uniprotId+names+",");
                 		// br.close();
                 }	    	    
			 }          
    	 }catch(Exception e){
    		 System.out.println(e);
    	 }
    	 finally{
             for(int i=0;i<array.size();i++) 
           	  bw.write(array.get(i)+'\t');
                 /*bw.newLine();bw.newLine();
             	  bw.write("共计有"+num+"个"); */
   		      bw.flush();
                //System.out.print( + '\r');
   		      bw.close();
        }
    }
}
