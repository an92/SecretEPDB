import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*按标签读取并放入数据库中*/
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


 
public class Insertmutation {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null; 
    	    String sql=null; 
    	    String sql1=null;
    	 String filepath="C:/Users/yia/Data/T3_blast";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.println("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
    		 File file = new File(filepath);  
    		 if (file.isDirectory()) {     
                 String[] filelist = file.list();   
                 for (int i = 0; i < filelist.length; i++) {  
                	 String position="";
            		 String wldtypeAA="";
            		 String mutAA="";
            		 String reference="";
            		 String disease="";
            		 String uniprotId="";
            		 String protein_id="";
            		 String mut="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){
                            	 if(s.startsWith("FT")){     
                            			 String mut1 = s.replaceAll("FT {2,}", "*");//把字符串s中的多个空格替换为*
                                		 mut+=mut1;
                                			 /*sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                                			 ResultSet  rs =stmt.executeQuery(sql);
                                			 if(rs.next()){   
                                				 protein_id=rs.getString("ProteinID");
                                	            }
                                			 System.out.println(Integer.parseInt(protein_id));*/
                                			/* sql1="insert into pdb(PDBProteinID,PDBAcc,Method,Resolution,Chains)values"
                                					 + "(\""+ Integer.parseInt(protein_id) +"\",\""+acc+"\",\""+method+"\",\""+resolution+"\",\""+chains+"\")";
                                			 stmt.execute(sql1);*/
                                		 	}
                            		 }                              	
                        	 }
                        // System.out.println(mut);
                         if(mut.contains("VARIANT")){
                        	 String ss=readfile.getName();                        	 
                        	 uniprotId=ss.substring(0, ss.indexOf("."));
                        	 System.out.print(uniprotId); System.out.print(";");
                        	 sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                			 ResultSet  rs =stmt.executeQuery(sql);
                			 if(rs.next()){   
                				 protein_id=rs.getString("ProteinID");
                	            }
                			 System.out.println(Integer.parseInt(protein_id));
                        	 
                        	 
                         }
                         }	                        
                 }	    	    
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
