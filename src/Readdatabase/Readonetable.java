package Readdatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * @author yia
 *从数据库中读取某一列数据到文本中
 */
public class Readonetable {

	public static void main(String[] args) throws Exception {
		 String driver = "com.mysql.jdbc.Driver";
 	    String url = "jdbc:mysql://localhost:3306/secretepdb";
 	    String username = "root";
 	    String password = "";
 	    Connection conn = null;
 	    Statement stmt = null;  	    
		BufferedReader br = null;
		String id="";
		File file = new File("F:/yia/Google Drive/SecretEPDB/NewData/NCBI_id.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		 try {       
  		   Class.forName(driver);    
  		   conn = DriverManager.getConnection(url, username, password);
  		   stmt = conn.createStatement();
            System.out.println("yes");
       } catch (Exception e) {
           System.out.print("MYSQL ERROR:" + e.getMessage());
       }
		try {
			//tring sql=("select *from protein ");
			String sql =("select * from protein"  );
			ResultSet rs = stmt.executeQuery(sql);// 执行SQL语句获得查询结果
			while(rs.next()){
				id = rs.getString(10);    // 括号里面是列数，get后面加的是这列的数据
				//System.out.print(id);
			bw.write(id+"\n");
			bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
