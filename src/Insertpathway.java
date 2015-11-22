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


 
public class Insertpathway {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/bacteria";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null; 
    	    String sql=null; 
    	    String sql1=null;
    	 String filepath="F:/Data/T3_blast";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
              // System.out.println("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
    		 File file = new File(filepath);  
    		 if (file.isDirectory()) {     
                 String[] filelist = file.list();   
                 for (int i = 0; i < filelist.length; i++) {  
            		 String uniprotId="";
            		 String protein_id="";
            		 String mut="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){
                            	 if(s.startsWith("DR")){     
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
                         
                         if(mut.contains("KEGG;")){
                        	 String ss=readfile.getName(); 
                        	 String[] pathway=mut.split("KEGG;");
                        	 String pathway1=pathway[1];
                        	 String pathway2=pathway1.substring(0, pathway1.indexOf("."));
                        	 uniprotId=ss.substring(0, ss.indexOf("."));
                        	 System.out.print(uniprotId); System.out.print(";");
                        	 sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                			 ResultSet  rs =stmt.executeQuery(sql);
                			 if(rs.next()){   
                				 protein_id=rs.getString("ProteinID");
                	            }
                			 System.out.println(Integer.parseInt(protein_id));
                			 System.out.println(pathway2);
                         }
                         }	                        
                 }	    	    
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
