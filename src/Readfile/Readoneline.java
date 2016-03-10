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
 *将fasta文件中的序列读入一行中
 */
public class Readoneline {
	    public static void main(String[] args) throws IOException {  
	    	File file_write = new File("C:/Users/yia/Google 云端硬盘/Server_Paper/data/database_data/T3/all_T3.txt");
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
	    		 File file = new File("C:/Users/yia/Google 云端硬盘/Server_Paper/data/database_data/T3/all_T3.fasta");
	             BufferedReader  br = new BufferedReader(new FileReader(file));
	             String s = null;
	             String ss="";
	             String[] str;
	             str= new String[1000];
	             int i=0;
	             while((s = br.readLine())!= null){               	  
	            	 if((s.startsWith(">"))){
	            		 str[i]=ss;
	            		 array.add(">"+i+"\n"+str[i]);
	            		 ss="";
	            		 i++;
	            		 continue;
	                     //seq = seq.replaceAll(" +","");//去掉所有空格   
	                    }
	            	 ss+=s;
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
