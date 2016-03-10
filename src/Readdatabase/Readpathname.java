package Readdatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Readpathname {
	public static void main(String[] args) throws IOException { 
		/*String filepath="C:/Users/yia/Clustal/Aln/"; 找到有Aln的文件
		String file_1="C:/Users/yia/Clustal/flag.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(file_1), true));
		File file = new File(filepath);
		if (file.isDirectory()) {     
          String[] filelist;
          filelist= new String[file.list().length];
          filelist=file.list();
          for (int i = 0; i < filelist.length; i++) {               	
     	     String name="";
         	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                  if (!readfile.isDirectory())  {
                 	 String ss=readfile.getName();                        	 
                 	 name=ss.substring(0, ss.indexOf("."));;//表Protein中UniprotID
                 	 System.out.println(name);
                 	 writer.write(name+",");
                 	 writer.flush();
                  	}
                  }
          writer.close();
          }*/
		String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/secretepdb";
	    String username = "root";
	    String password = "admin";
	    Connection conn = null;
	    Statement stmt = null;  	    
	    String filepath="C:/Users/yia/Clustal/flag.txt";
	    String sql="";
	    String[] str=null;
	    int n=0;
	 try {       
		   Class.forName(driver);    
		   conn = DriverManager.getConnection(url, username, password);
		   stmt = conn.createStatement();
           System.out.println("yes");
     } catch (Exception e) {
         System.out.print("MYSQL ERROR:" + e.getMessage());
     }
	 try{
		 BufferedReader br = new BufferedReader(new FileReader(filepath));
		 String s = null;
		 while((s = br.readLine()) != null){
				  str = s.split(",");
		 }  
		/* sql="update protein set flagClustal=0";
    	 boolean rs = stmt.execute(sql);*/
		 for(int j=0;j<str.length;j++){
			sql="update protein set flagClustal=1 where ProteinID=\""+str[j]+"\";";
	    	 boolean rs = stmt.execute(sql);
	    	 System.out.println(str[j]);
			 
		 }
	 }catch (Exception e) {
         System.out.print("MYSQL ERROR:" + e.getMessage());
     }
		 }
}