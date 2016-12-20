package InsertDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*按标签读取并放入数据库中*/
import java.sql.Statement;


 
public class InsertPdb {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null; 
    	    String sql=null; 
    	    String sql1=null;
    	 String filepath="F:\\yia\\txt\\";
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
    		 if (file.isDirectory()) {     
                 String[] filelist = file.list();   
                 for (int i = 0; i < filelist.length; i++) {  
                	 String acc="";
            		 String method="";
            		 String resolution="";
            		 String chains="";
            		 String uniprotId="";
            		 String protein_id="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){
                            	 if(s.startsWith("DR")){                             		                            			 
                            			 String pdb1 = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                                		 String[] pdb2 = pdb1.split("\\*");
                                		 String pdb3=pdb2[1];
                                		 if(pdb3.startsWith("PDB;")){
                                			 String ss=readfile.getName();                        	 
                                        	 uniprotId=ss.substring(0, ss.indexOf("."));
                                        	 String[] pdb4=pdb3.split(";");
                                			 acc=pdb4[1];
                                			 method=pdb4[2];
                                			 resolution=pdb4[3];
                                			 chains=pdb4[4];
                                			 //System.out.println(uniprotId);
                                			System.out.print(acc);
                                			 System.out.print(method);
                                			 System.out.print(resolution);
                                			 System.out.println(chains);
                                			 sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                                			 ResultSet  rs =stmt.executeQuery(sql);
                                			 if(rs.next()){   
                                				 protein_id=rs.getString("ProteinID");
                                	            }
                                			 System.out.println(Integer.parseInt(protein_id));
                                			 sql1="insert into pdb(PDBProteinID,PDBAcc,Method,Resolution,Chains)values"
                                					 + "(\""+ Integer.parseInt(protein_id) +"\",\""+acc+"\",\""+method+"\",\""+resolution+"\",\""+chains+"\")";
                                			 stmt.execute(sql1);
                                		 	} 
                            		 }                              	
                        	 }
                         }	                        
                 }	    	    
			 }          
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
