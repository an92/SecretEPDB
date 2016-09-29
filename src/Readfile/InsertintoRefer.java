package Readfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*按标签读取并放入数据库中*/
import java.sql.Statement;


 
/**
 * @author yia
 * 根据内容向数据库写入数据库的一列表中。
 *
 */
public class InsertintoRefer {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null; 
    	    String sql=null; 
    	    String sql1=null;
    	    BufferedReader br = null;
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.print("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
			 String s = null;
			 int i=1;
    		 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\species.txt"));
			 while((s = br.readLine()) != null){
				  System.out.println(s);
				   sql = "update protein set Organism='"+s+"'where ProteinID="+i+"";
	  				stmt.execute(sql);
	  				i++;
				 }				
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
