package InsertDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertPtms {

	public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "";
    	    Connection conn = null;
    	    Statement stmt = null; 
    	    String sql=null; 
    	    String sql1=null;
    	    int m=0;
    	 String filepath="F:\\yia\\txt\\";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.println("yes");
         } catch (Exception e) {
             System.out.println("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
    		 File file = new File(filepath);  
    		 if (file.isDirectory()) {     
                 String[] filelist = file.list();   
                 for (int i = 0; i < filelist.length; i++) {  
                	 String PTMsProteinID="";
            		 String Position="";
            		 String PTMsPTMType="";
            		 String PTMskinase="";
            		 String PubMeds="";
            		 String pubMeds="";
            		 String uniprotId="";
            		 String pub="";
            		 int  flag=0;
            		 String[] ptms5=null;
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 while((s = br.readLine()) != null){
                            	 if(s.startsWith("FT")){                             		                            			 
                            			 String ptms1 = s.replaceAll("FT {2,}", "*");//把字符串s中的多个空格替换为*
                                		 String[] ptms2 = ptms1.split("\\*");
                                		 pub+=ptms2[1];
                                		 if(ptms2[1].startsWith("MOD_RES")){
                                			 String ss=readfile.getName();                        	 
                                        	 uniprotId=ss.substring(0, ss.indexOf("."));
                                        	 String ptms3 = ptms2[1].replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                                        	 String[] ptms4=ptms3.split("\\*");
                                        	 Position=ptms4[1];
                                        	 if(ptms4[2].contains(";")){
                                        		 flag=1;
                                        		 ptms5=ptms4[3].split(";");
                                        	 }
                                        	 switch(flag)
                                        	 {
                                        	 case 0: PTMsPTMType=ptms4[3];PTMskinase="unknown";break;
                                        	 case 1: PTMsPTMType=ptms5[0];PTMskinase=ptms5[1];break;
                                        	 default:System.out.println("ok,yeah");  
                                        	 }
                                		 	} 
                            		 }
                            	
                        	 }
                        	 if(pub.contains("MOD_RES")&pub.contains("{")){
                        		 String[] pub_1=pub.split("MOD_RES");
                        		 String pub_2=pub_1[1].substring(pub_1[1].indexOf("{")+1, pub_1[1].indexOf("}"));
                        		 String[] str=pub_2.split(",");
                        		 for(int a=0;a<str.length;a++){
                        			 PubMeds+=str[a].substring(str[a].indexOf("d:")+2, str[a].length())+";";
                        		 }
                        		 System.out.println(uniprotId);
                            	 System.out.println(Position);
                            	 System.out.println(PTMsPTMType);
                            	 System.out.println(PTMskinase);
                            	 System.out.println(PubMeds);
                            	 sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                    			 ResultSet  rs =stmt.executeQuery(sql);
                    			 if(rs.next()){   
                    				 PTMsProteinID=rs.getString("ProteinID");
                    	            }
                    			 System.out.println(Integer.parseInt(PTMsProteinID));
                    			sql1="insert into ptms(PTMsProteinID,Position,PTMsPTMType,PTMskinase,PubMeds)values"
                    					 + "(\""+ Integer.parseInt(PTMsProteinID) +"\",\""+Position+"\",\""+PTMsPTMType+"\",\""+PTMskinase+"\",\""+PubMeds+"\")";
                    			 stmt.execute(sql1);
                        	 }
                        	 else if(pub.contains("MOD_RES")){
                        		 pubMeds="-";
                        		 System.out.println(uniprotId);
                            	 System.out.println(Position);
                            	 System.out.println(PTMsPTMType);
                            	 System.out.println(PTMskinase);
                            	 System.out.println(pubMeds);
                            	 sql = "select ProteinID from protein where UniprotID=\""+uniprotId+"\";";
                    			 ResultSet  rs =stmt.executeQuery(sql);
                    			 if(rs.next()){   
                    				 PTMsProteinID=rs.getString("ProteinID");
                    	            }
                    			 System.out.println(Integer.parseInt(PTMsProteinID));
                    			 sql1="insert into ptms(PTMsProteinID,Position,PTMsPTMType,PTMskinase,PubMeds)values"
                    					 + "(\""+ Integer.parseInt(PTMsProteinID) +"\",\""+Position+"\",\""+PTMsPTMType+"\",\""+PTMskinase+"\",\""+pubMeds+"\")";
                    			 stmt.execute(sql1);
                        		 
                        	 }m++;
                         }
                         System.out.println(m);
                 }	    	    
			 }          
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
