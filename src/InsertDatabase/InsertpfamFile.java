package InsertDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

  /**
 * @author yia
 *首先根据DownloadPfam脚本生成pfam文件，然后根据该文件写道数据库中。
 */
public class InsertpfamFile {
  
		public static void main(String[] args) throws Exception {

			  InsertpfamFile t = new InsertpfamFile();
		      String type="";
		      String id_1="";
		      String pfamid="";
		      String start="";
		      String end="";
		      String pfam_id="";
			  String driver = "com.mysql.jdbc.Driver";
			  String url = "jdbc:mysql://localhost:3306/secretepdb";
			  String username = "root";
			  String password = "";
			  Connection conn = null;
			  Statement stmt = null;  	    
			  String sql="";
			  String sql1="";
			 try {       
				   Class.forName(driver);    
				   conn = DriverManager.getConnection(url, username, password);
				   stmt = conn.createStatement();
		         System.out.println("yes");
			 	  } 
			 catch (Exception e) {
		       System.out.print("MYSQL ERROR:" + e.getMessage());
			 	  }
			  	 File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\pfam\\pfam.txt");
				 FileReader fr = new FileReader(file);
				 BufferedReader br = new BufferedReader(fr);
				 String str = br.readLine();
				while(str!=null)
						{
							String[] id1=str.split(",");
							id_1=id1[0];
							type=id1[1];
							pfamid=id1[2];
						    start=id1[3];
						    end=id1[4];	
				            sql = "select ProteinID from protein where UniprotID=\""+id_1+"\";";
				       	    ResultSet  rs =stmt.executeQuery(sql);
				       		 if(rs.next()){   
				       				 pfam_id=rs.getString("ProteinID");
				       		 }
				       		str = br.readLine();
				       		sql1="insert into pfam(PfamProteinId,id,type,start,end)values"
							 + "(\""+ Integer.parseInt(pfam_id) +"\",\""+pfamid+"\",\""+type+"\",\""+start+"\",\""+end+"\")";
					 stmt.execute(sql1);
			       		  System.out.println(Integer.parseInt(pfam_id));
			       	      System.out.println(type);
			       	      System.out.println(id_1);
			       	      System.out.println(start);
			       	      System.out.println(end);
				          
				          }
  					}

} 
