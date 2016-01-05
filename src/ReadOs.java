import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * @author yia
 *读取Orgainsm的数据并输出
 */
public class ReadOs {
    public static void main(String[] args) throws SQLException, IOException {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	    String filepath="C:/Users/yia/Data/Os.xls";
    	    String ID="";
    	    String sql="";
    	    int n=0;
      	    WritableWorkbook book=null;
      	    WritableSheet sheet=null;
      	    int rownum=1;
      	    String sheetName="Os";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.println("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
    		book=Workbook.createWorkbook(new File(filepath)); 
    		sheet= workbook.createSheet(sheetName,0);//名字为sheetName的工作薄；
    	 }
    	 catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 sql="select Organism from protein";
    	 ResultSet rs = stmt.executeQuery(sql);
    	  while(rs.next()){
    		  Vector<string></string> col =new Vector<string></string>();//用以保存一行数据
    	    ID = rs.getString(1);
    	    writer.write(ID+" ");
    	    n++;
    	    writer.flush();
    	  }
    	  System.out.println(n);
    }
 }

