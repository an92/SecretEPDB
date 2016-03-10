package Runcmd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yia
 *从数据库中读取数据，并使用jar文件运行，写成不同的文件，使用java程序运行cmd程序,该程序是使用的VSL2B工具。
 */
public class RunVSL2B {
	
	public static void mysqlConnection() throws SQLException, IOException{  //从数据库中读取数据并生成了文件
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
	    		System.out.println("yes");
	    	} catch (Exception e) {
	    			System.out.print("MYSQL ERROR:" + e.getMessage());
	    	}
		   
	       sql = "select * from protein";//查询语句  
	       ResultSet rs = stmt.executeQuery(sql);
		   List<String> list=new ArrayList<String>();
		   while (rs.next()) {
		    list.add(rs.getString(1)+";"+rs.getString(7)); 
		    //list.add(rs.getString(7));
		   }  
		   if(list != null && list.size()>0){
		          String[] arr=new String[list.size()];//创建一个和list长度一样的数组  
		          for(int i=0;i<list.size();i++){  
		        	  arr[i]=list.get(i);//数组赋值了。  
		          }  
		          for(int i=0;i<arr.length;i++){  
		              //System.out.println(arr[i]); 
		              String[] str=arr[i].split(";");
			          String strss=str[0];//Id
			          String str_1=str[1];//sequence
			          BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/yia/VSL2B/" + strss + ".fasta"));
			          bw.write(str_1);
			      	  bw.close();
		          }  
		   }  
		}  
	
	 public static  void openExe(String dir) {
		  Runtime rn = Runtime.getRuntime();
		  try {
		   Process p=rn.exec(dir);
		   if (p.waitFor() != 0) {
		        if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束     
		            System.err.println("命令执行失败!"); 
		   }
		  } catch (Exception e) {
		   System.out.println("Error!"+e);
		  }
		 }
	  public static void main(String[] args) throws SQLException, IOException { 
		  mysqlConnection();
		  String filepath="C:/Users/yia/VSL2B/";	
		  String filepath_pred="C:\\Users/yia/VSL2B_pred/";
		  File file = new File(filepath);
		  String name="";
		  if (file.isDirectory()) {     
              String[] filelist;
              filelist= new String[file.list().length];
              filelist=file.list();
              for (int i = 0; i < filelist.length; i++) {     
            	  File readfile = new File(filepath + "\\" + filelist[i]);
            	  if (!readfile.isDirectory())  {
                 	 String ss=readfile.getName();                        	 
                 	 name=ss.substring(0, ss.indexOf("."));;//name是表protein中的ID，也就是文件的名称。
                 	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                 	 System.out.println(readfile);
                 	 System.out.println(name);
                 	 String s = null;
                 	 while((s = br.readLine()) != null){     
            	  	String dir="cmd /c java -jar C:\\Users/yia/Downloads/VSL2/VSL2.jar -s:"+readfile+" -w:1 > "+filepath_pred+name+".pred";
            	  	openExe(dir);
                 	 }
            	  }
              }
	  }
	  }
}
