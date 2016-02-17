import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


 
public class text_2 {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/bacteria";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	     String func=null;    	     
    	     String uniprotId=null;
    	    String filepath="C:/Users/yia/Google 云端硬盘/type6 re";
    	    String sql="";
    	 try{
    		 File file = new File(filepath);
    		 //System.out.println(file.list().length);
    		 if (file.isDirectory()) {     
                 String[] filelist;
                 filelist= new String[file.list().length];
                 filelist=file.list();
                 for (int i = 0; i < filelist.length; i++) {               	
            	     String function="";
            	     String function1="";
            	     String fun1="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 String ss=readfile.getName();                        	 
                        	 uniprotId=ss.substring(0, ss.indexOf("."));;//表Protein中UniprotID
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){               	  
                            	 if(s.startsWith("CC")){                            		                           		                            		
                            		function1+=s;                            		                            		         		                            		
                            	}
                            	} 
                         }	
                         if(function1.contains("type VI")){    
                        	 System.out.println(uniprotId);
                        	  fun1 = function1.replaceAll("CC {2,}", " ");//把字符串s中的多个空格替换为*   
                        	 /*int begin=fun1.indexOf(":");
                        	 int end=fun1.indexOf("{");
                        	 function=fun1.substring(begin+2,end);   */                       			
                         }    
                        //System.out.println(fun1);
                 }	    	    
			 }          
    	 }catch(Exception e){
    		 System.out.println(sql);
    		 
    	 	}
    }
}
