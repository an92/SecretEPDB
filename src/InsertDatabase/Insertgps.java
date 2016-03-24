package InsertDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insertgps {
    @SuppressWarnings("resource")
	public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	    String filepath="C:\\Users\\yia\\Google Drive\\gps\\";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.println("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
             File file = new File(filepath);  
        		 if (file.isDirectory()) {     
                     String[] filelist = file.list(); 
                     for (int i = 0; i < filelist.length; i++) { 
                    	 int gps_proteinid=0;
                         int position = 0;
                         double score=0;
                         double cutoff=0;
                         String code="";
                         String kinase="";
                         String petide="";
                         String[] ss=null;
                         String[] sstr=null;
                         String sql="";
                         File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){ 
                        		 String str="";
                        		 if(s.startsWith(">")){
                        			 ss=s.split("\\|");
                        			 gps_proteinid=Integer.parseInt(ss[0].substring(1, ss[0].length()));//protein中的id.
                        			 s=br.readLine();
                        		 }
                        		 	str+=s;
                        		 	sstr=str.split("\t");
                        		 	position=Integer.parseInt(sstr[0]);
                        		 	code = sstr[1];
                        		 	kinase = sstr[2];
                        		 	petide = sstr[3];
                        		 	score = Double.valueOf(sstr[4]);
                        		 	cutoff = Double.valueOf(sstr[5]);
                        		 	System.out.println(sstr[0]);
                        		 	/*System.out.println(sstr[1]);
                        		 	System.out.println(sstr[2]);
                        		 	System.out.println(sstr[3]);
                        		 	System.out.println(sstr[4]);
                        		 	System.out.println(sstr[5]);*/
                        		 	if(score>=11){
                        		 		sql = "insert into gps(gps_proteinid,position,code,kinase,petide,score,cutoff)values"
    											+ "(\""+ gps_proteinid +"\",\""+position+"\",\""+code+"\",\""+kinase+"\",\""+petide+"\",\""+score+"\",\""+cutoff+"\")";
    									stmt.execute(sql);
                        		 	}
                        	}
                         }
                     }
        		 }
                 		// br.close();
    	 }catch(Exception e){
    		 System.out.println(e);
    	 	}
    }
}
