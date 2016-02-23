import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/*按标签读取并放入数据库中*/
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


 
/**
 * @author yia
 *写入mutation表，程序还稍有问题。
 */
public class Insertmutation {
	 @SuppressWarnings("unused")
	private static String getText(String str, int st, int ed) {
	        int n = 0;
	        int pos = -1;
	        while (n < st) {
	            pos = str.indexOf("*", pos + 1);
	            if (pos == -1) {
	                return "";
	            }
	            n++;
	        }
	        int st_pos = pos;
	        while (n < ed) {
	            pos = str.indexOf("*", pos + 1);
	            if (pos == -1) {
	                return str.substring(pos + 1);
	            }
	            n++;
	        }
	        return str.substring(st_pos + 1, pos);
	    }
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null; 
    	    String sql=null; 
    	    String sql1=null;
    	 String filepath="C:/Users/yia/Google 云端硬盘/Server_Paper/data/dabase_data/T6/T6_uniprot";
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
                	 String position="";
            		 String wldtypeAA="";
            		 String mutAA="";
            		 String reference="";
            		 String disease="";
            		 String uniprotId="";
            		 String protein_id="";
            		 String mut="";
            		 String mutt="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){
                            	 if(s.startsWith("FT")){     
                            			 String mut1 = s.replaceAll("FT {2,}", "*");//把字符串s中的多个空格替换为*
                                		 mut+=mut1;
                                		 	}
                            		 }                              	
                        	 }
                         if(mut.contains("VARIANT")){
                        	 String ss=readfile.getName();                        	 
                        	 uniprotId=ss.substring(0, ss.indexOf("."));
                        	 sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                			 ResultSet  rs =stmt.executeQuery(sql);
                			 if(rs.next()){   
                				 protein_id=rs.getString("ProteinID");
                	            }
                        	 String[] var=mut.split("VARIANT");
                        	 for(int j=1;j<var.length;j++){
                        		      mutt = var[j].replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                        		      position=getText(mutt,1,2);
                        		      System.out.println(position);
                        		      String var_1=getText(mutt,3,4);
                        		      wldtypeAA=var_1.substring(0, var_1.indexOf("-"));
                             		  String var_2=var_1.substring(5);
                             		  mutAA=(String) var_2.subSequence(0, 1);
                             		 System.out.println(wldtypeAA);
                             		 System.out.println(mutAA);
                             		  if(mutt.contains("PubMed")){
                             			  reference=mutt.substring(mutt.indexOf("PubMed")+7, mutt.indexOf("}"));
                             		  }
                             		  else{
                             			 reference="unknown";
                             		  }
                             		  if(mutt.contains("(in")& !mutt.contains("strain") & !mutt.contains("plasmid")){
                             			 disease=mutt.substring(mutt.indexOf("(in")+4, mutt.indexOf(")."));;
                             		  }
                             		  else{
                             			 disease="-";
                             		  }
                             		 System.out.println(reference);
                             		 System.out.println(disease);
                             		System.out.println(uniprotId);
                             		sql1="insert into mutation(mut_proteinID,position,wldtypeAA,mutAA,disease,reference)values"
                       					 + "(\""+ Integer.parseInt(protein_id) +"\",\""+position+"\",\""+wldtypeAA+"\",\""+mutAA+"\",\""+disease+"\",\""+reference+"\")";
                       			   stmt.execute(sql1);
                        	 }
                         }
                         }	                        
                 }	    	    
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
