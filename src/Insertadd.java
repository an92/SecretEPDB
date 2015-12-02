import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
 update a row data 
*
*/
public class Insertadd {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		 String driver = "com.mysql.jdbc.Driver";
 	     String url = "jdbc:mysql://localhost:3306/secretepdb";
 	     String username = "root";
 	     String password = "admin";
 	     Connection conn = null;
 	     Statement stmt = null;  	    
 	     String sql="";
 	 try {       
 		   Class.forName(driver);    
 		   conn = DriverManager.getConnection(url, username, password);
 		   stmt = conn.createStatement();
            System.out.print("yes");
      } catch (Exception e) {
          System.out.print("MYSQL ERROR:" + e.getMessage());
      }
			String str="SD00001"; 
			int i;
			String strs = str.substring(str.indexOf("D")+2); 
			for(i=0;i<589;i++){
				String ss="";
				String result = ""+(Integer.parseInt(strs)+i); 
				int size = 4-result.length(); 
				for(int j=0;j<size;j++){ 
					result="0"+result; 
				} 
				ss=str.substring(0,str.indexOf("D")+2)+result; 
				System.out.println(ss);
				int id=i+1;
				System.out.println(id);
			    sql = "update protein set DBid='"+ss+"' where ProteinID='"+id+"'";
			    stmt.executeUpdate(sql);
				} 
			}
}
