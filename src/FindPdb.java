import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


 
public class FindPdb {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/bacteria";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	     String func=null;    	       
    	     String uniprotId=null;
    	    String filepath="F:/Data/T3/";
    	    String sql="";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.print("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
    		 File file = new File(filepath);
    		 System.out.println(file.list().length);
    		 if (file.isDirectory()) {     
                 String[] filelist;
                 filelist= new String[file.list().length];
                 filelist=file.list();
                 for (int i = 0; i < filelist.length; i++) {               	                	 
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 String ss=readfile.getName();                        	 
                        	 uniprotId=ss.substring(0, ss.indexOf("."));;//表Protein中UniprotID
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 boolean isName = true;
                        	 String s = null;
                        	 while((s = br.readLine()) != null){               	  
                            	 if(s.startsWith("DR")){ 
                            		 if(s.contains("PDB")){
                            			 System.out.println(uniprotId);
                            			 String pdb1 = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                                		 String[] pdb2 = pdb1.split("\\*");   
                                		 String name2=pdb2[1];
                                		 String str=name2.substring((name2.indexOf("=")+"=".length()), name2.indexOf(";"));//表protein中Name的值                                		                           		                             			
                            		 }                   		               		                       		                     			                        		                  		 
                            	} 
                            	       
                            } 
                        	 		                        	                         	    
                         }	
                                    		
         			  /* sql = "insert into protein(UniprotID,Name,Evidence,MolecularWeight,Function,Sequence,Length,altUniprotACC,DBid,Organism,Gene,allNames,flagType)values"
         						+ "(\""+ uniprotId +"\",\""+name+"\",\"\",\""+molecalarweight+"\",\""+function+"\",\""+sequence+"\",\""+length+"\",\""+alt+"\",\"\",\""+organism+"\",\""+gene+"\",\""+names+"\",\"T3_blast\")";
         				stmt.execute(sql);*/
                 		// br.close();
                 }	    	    
			 }          
    	 }catch(Exception e){
    		 System.out.println(sql);
    		 
    	 	}
    }
}
