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
 *读取数据库中T4SE的数据，Leigionella的数据,189到723之间
 */
public class Readplogodata {
    public static void main(String[] args) throws SQLException, IOException {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	    String filepath="C:/Users/yia/Google Drive/plogo_T4.txt";
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
    	 sql="select ProteinID,UniprotID,Sequence from protein where  ProteinID between 189 and 723";
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