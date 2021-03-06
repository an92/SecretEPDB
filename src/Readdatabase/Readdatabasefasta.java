package Readdatabase;
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
 *读取数据库并将其序列输出
 */
public class Readdatabasefasta {
    public static void main(String[] args) throws SQLException, IOException {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	    String filepath="C:\\Users\\yia\\study\\soft\\Blast\\blast\\db\\sql_fasta\\sql.dasta";
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
    	 sql="select ProteinID,UniprotID,Sequence from protein";
    	 ResultSet rs = stmt.executeQuery(sql);
    	 String proteinID="";
 	     String uniprotID="";
 	     String seq="";
    	  while(rs.next()){
    		  proteinID = rs.getString(1);
    		  uniprotID = rs.getString(2);
    		  seq = rs.getString(3);
    		  writer.write(">"+proteinID+"|"+uniprotID+"|");
    		  writer.newLine();
    		  writer.write(seq);
    		  writer.newLine();
    		  n++;
    		  writer.flush();
    	  }
    	  System.out.println(n);
    }
 }