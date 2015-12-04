import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insertdisorder {
    @SuppressWarnings("resource")
	public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	     String Id=null;
    	    String filepath="C:/Users/yia/Data/DB_pred";
    	    String filepath_pred="C:/Users/yia/Data/DB";
    	    String sql="";
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
    		 File file_pred=new File(filepath_pred);
    		 System.out.println(file.list().length);
    		 if (file.isDirectory()) {     
                 String[] filelist;
                 String[] filelist_pred;
                 String str="";
                 String str_1="";
                 int start;//开始的位置
                 int end;
                 String seq="";
                 filelist= new String[file.list().length];
                 filelist_pred= new String[file_pred.list().length]; 
                 filelist=file.list();
                 filelist_pred=file_pred.list();
                for (int i = 0; i < filelist.length; i++) { 
                  //for (int i = 0; i < 1; i++) {
                	 File readfile = new File(filepath + "\\" + filelist[i]);  
                	// File readfile = new File("C:/Users/yia/Data/DB_pred/1.pred");  
                         if (!readfile.isDirectory())  {
                        	 String ss=readfile.getName();                        	 
                        	 Id=ss.substring(0, ss.indexOf("."));;//表Protein中的ID号
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while(!(s = br.readLine()).equals("Prediction Scores:") ){ 
                        		     str_1+=s+";";
                        		}
						String str_2 = str_1.substring(str_1.indexOf(":") + 2, str_1.lastIndexOf(";"));// get
																										// position
						for (int m = 0; m < filelist_pred.length; m++) {
							File pred = new File(filepath_pred + "\\" + filelist_pred[m]);
							String pred_1 = pred.getName();
							str_1 = pred_1.substring(0, pred_1.indexOf("."));
							if (str_1.equals(Id)) {// 找到相同的文件
								BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(pred)));
								byte[] data = new byte[10240];
								FileInputStream bbb = new FileInputStream(pred);
								int a = bbb.read(data);
								int[][] index = new int[4][2];
								String[] str_3 = str_2.split(";");
								String[][] sstmp = new String[str_3.length-1][2];
								String[] tmp = new String[str_3.length];
								for (int q = 0; q < str_3.length - 1; q++) {
									String stmp = str_3[q];
									sstmp[q] = stmp.split("-");
								}
								for (int k = 0; k < sstmp.length; k++) {
									int dis = Integer.parseInt(sstmp[k][1]) - Integer.parseInt(sstmp[k][0]);
									String ssss = new String(data, Integer.parseInt(sstmp[k][0]) - 1, dis+1);
									tmp[k] = ssss;
									start=Integer.parseInt(sstmp[k][0]);
									end=Integer.parseInt(sstmp[k][1]);
									seq=tmp[k];
									System.out.print(start);//起始位点
									System.out.print("---");
									System.out.println(end);//结束位点
									System.out.println(seq);//序列
									System.out.println(Id);//name.序列
								}
							}
						}
					}
                         
         			  /* sql = "insert into protein(UniprotID,Name,Evidence,MolecularWeight,Function,Sequence,Length,altUniprotACC,DBid,Organism,Gene,allNames,flagType)values"
         						+ "(\""+ uniprotId +"\",\""+name+"\",\"\",\""+molecalarweight+"\",\""+function+"\",\""+sequence+"\",\""+length+"\",\""+alt+"\",\"\",\""+organism+"\",\""+gene+"\",\""+names+"\",\"T3_blast\")";
         				stmt.execute(sql);*/
                 		// br.close();
                 }	    	    
			 }          
    	 }catch(Exception e){
    		 System.out.println(e);
    		 
    	 	}
    }
}
