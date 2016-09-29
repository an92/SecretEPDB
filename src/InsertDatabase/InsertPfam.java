package InsertDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
 

  /**
 * @author yia
 *写入pfam,此程序會出現時間超時情況，要寫入pfam表，應該使用InsertpfamFile程序。
 */
public class InsertPfam {
     public  Document getDocument (String url){
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
             e.printStackTrace();
         }
        return null;
     }
  public static void main(String[] args) throws Exception {

	  InsertPfam t = new InsertPfam();
      String type="";
      String id_1="";
      String start="";
      String end="";
      String pfam_id="";
	  String driver = "com.mysql.jdbc.Driver";
	   String url = "jdbc:mysql://localhost:3306/secretepdb";
	    String username = "root";
	    String password = "";
	    Connection conn = null;
	    Statement stmt = null;  	    
	    String uniprotId=null;
	    String sql="";
	    String sql1="";
	    int length=0;
	 try {       
		   Class.forName(driver);    
		   conn = DriverManager.getConnection(url, username, password);
		   stmt = conn.createStatement();
         System.out.println("yes");
    } catch (Exception e) {
       System.out.print("MYSQL ERROR:" + e.getMessage());
   }
	  File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\SqlFile\\Uniprot_sql.txt");
		 FileReader fr = new FileReader(file);
		 BufferedReader br = new BufferedReader(fr);
		 String str = br.readLine();
		while(str!=null)
		{
			String[] id1=str.split("\n");
			for(int a=0;a<id1.length;a++){
				String id=id1[a];
				length++;
				String url_1="http://pfam.xfam.org/protein/" + id;
	        	 System.out.println(url_1);
	        	 System.out.println(length);
	             Document doc = t.getDocument(url_1); // 获取目标HTML代码
	             Elements elements1 = doc.select("[class=resultTable details]");
	             Elements elements2 = elements1.select("[class=odd]");
	             int aa=elements2.size();
	             String[] array = new String[aa];
	             if(elements2!=null){
	            	 for (int i=0;i<aa;i++){
	                 	 array[i]=elements2.get(i).text();
	                 }
	                  for (int l=0;l<array.length;l++){
	                 	 if(array[l].startsWith("Pfam")){
	                 		 uniprotId=id.toString();
	                 		 String[] pfam_1=array[l].split(" ");
	                 		 type=pfam_1[0];
	                 		 id_1=pfam_1[1];
	                 	     start=pfam_1[2];
	                 	     end=pfam_1[3];
	                 	    sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
	       				 ResultSet  rs =stmt.executeQuery(sql);
	       				 if(rs.next()){   
	       					 pfam_id=rs.getString("ProteinID");
	       		            }
	       				/*sql1="insert into pfam(PfamProteinId,id,type,start,end)values"
	           					 + "(\""+ Integer.parseInt(pfam_id) +"\",\""+id_1+"\",\""+type+"\",\""+start+"\",\""+end+"\")";
	           			 stmt.execute(sql1);*/
	           			 
	       				  System.out.println(Integer.parseInt(pfam_id));
	       	              System.out.println(type);
	       	          	  System.out.println(id_1);
	       	          	  System.out.println(start);
	       	          	  System.out.println(end);
	                 	 }
	                  }
	             }
	            
	        }				
				str = br.readLine();
			}
		}
  } 
