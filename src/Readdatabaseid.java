import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ay
 *该程序是一句gi 号找到其在数据库的编号。
 */
public class Readdatabaseid {
		    public static void main(String[] args) throws IOException {  
		    	/*该模块是将gi号以及序列写到文件中。
		    	 * File file_write = new File("F:/Google Drive/Clustal/blast_file/all_T6.txt");
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
		    		 File file = new File("F:/Google Drive/Clustal/blast_file/all_T6.fasta");
		             BufferedReader  br = new BufferedReader(new FileReader(file));
		             String s = null;
		             String ss="";
		             String[] str;
		             str= new String[1000];
		             int i=0;
		             while((s = br.readLine())!= null){               	  
		            	 if((s.startsWith(">"))){
		            		 str[i]=ss;
		            		 String[] ids=s.split("\\|");
		            		 String id=ids[1];
		            		 array.add(">"+id+"\n"+str[i]);
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
		    }*/
		    	String driver = "com.mysql.jdbc.Driver";
	    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
	    	    String username = "root";
	    	    String password = "admin";
	    	    Connection conn = null;
	    	    Statement stmt = null; 
	    	    String sql=null; 
	    	    String sql1=null;
	    	    String seq="";
	    	    
	    	 try {       
	    		   Class.forName(driver);    
	    		   conn = DriverManager.getConnection(url, username, password);
	    		   stmt = conn.createStatement();
	               System.out.println("yes");
	         } catch (Exception e) {
	             System.out.print("MYSQL ERROR:" + e.getMessage());
	         }
	    	 try{
	    		 File file = new File("F:/Google Drive/Clustal/blast_file/all_T6.txt"); 
	    		 BufferedReader  br = new BufferedReader(new FileReader(file));
	    		 String s=null;
	    		 while((s = br.readLine())!= null){
	    			 String protein_id="";
	 	    	    String id="";
	    			 if(s.startsWith(">")){
	    				  id=s.substring(1, s.length());//gi 号
	    				 seq=br.readLine();
	    				 sql = "select ProteinID from protein where Sequence=\""+seq+"\";";
            			 ResultSet  rs =stmt.executeQuery(sql);
            			 if(rs.next()){   
            				 protein_id=rs.getString("ProteinID");
            	            }
	    		 }
	    			 System.out.println(sql);
	    			 System.out.println(id+"=="+protein_id);
	    		 	}
	    	 }
	    	 catch(Exception e){       
	         }
		    }
}

