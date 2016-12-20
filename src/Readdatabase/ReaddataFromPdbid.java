package Readdatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yia
 *根据DBid 从数据库中找到ProteinID.
 */
public class ReaddataFromPdbid {
    public static void main(String[] args) throws SQLException, IOException {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	    File file_write= new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\pdb_ncbi_ref.txt");
   		 	FileWriter fw = new FileWriter(file_write.getAbsoluteFile(),true);
   		 	BufferedWriter bw = new BufferedWriter(fw);
    	    String sql="";
    	    int n=0;
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.println("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 
    	 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\pdb_ncbi");
 		 FileReader fr = new FileReader(file);
 		 BufferedReader br = new BufferedReader(fr);
 		 String str = br.readLine();
 		 String id=null;
 		 while(str!=null)
 		 {
 			String[] id1=str.split("\n");
 			for(int i=0;i<id1.length;i++){
 				id=id1[i];
 				str = br.readLine();
 			}
 		 }
    	 sql="select ProteinID from protein where DBid = '+id+' ";
    	 ResultSet rs = stmt.executeQuery(sql);
    	 String proteinID="";
    	  while(rs.next()){
    		  proteinID = rs.getString(1);
    		 bw.write(""+proteinID+","+id+"");
             bw.newLine();
        	   n++;
        	 bw.flush();
    		  }
    	  }
    }
