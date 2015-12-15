import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yia
 *读取pdb的数据并输出
 */
public class Readdatabase {
    public static void main(String[] args) throws SQLException, IOException {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	    String filepath="C:/Users/yia/Data/PDBs/PDBs.txt";
    	    String PdbID="";
    	    String sql="";
    	    int n=0;
      	    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filepath), true));
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.println("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 sql="select PDBAcc from pdb";
    	 ResultSet rs = stmt.executeQuery(sql);
    	  while(rs.next()){
    	    PdbID = rs.getString(1);
    	    writer.write(PdbID+" ");
    	    n++;
    	    writer.flush();
    	  }
    	  System.out.println(n);
    }
 }