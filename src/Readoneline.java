import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ay
 *将fasta文件中的序列读入一行中
 */
public class Readoneline {
	    public static void main(String[] args) {   
	    	 try{
	    		 File file = new File("F:/Google Drive/Server_Paper/data/depedent dataset/T4/T4_new_dep_P.fasta");
	             BufferedReader  br = new BufferedReader(new FileReader(file));
	             String s = null;
	             String ss="";
	             String[] str;
	             str= new String[58];
	             int i=0;
	             while((s = br.readLine())!= null){               	  
	            	 if((s.startsWith(">"))){
	            		 str[i]=ss;
	            		 System.out.println(str[i]);
	            		 ss="";
	            		 continue;
	                     //seq = seq.replaceAll(" +","");//去掉所有空格   
	                    }
	            	 ss+=s;
	            	 
	            	 i++;
	                  } 
	    	 }catch(Exception e){
	    		 System.out.println(e);
	    	 	}
	    }
	}
