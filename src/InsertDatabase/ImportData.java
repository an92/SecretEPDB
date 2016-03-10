package InsertDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


 
public class ImportData {
    public static void main(String[] args) {       
    	    String driver = "com.mysql.jdbc.Driver";
    	    String url = "jdbc:mysql://localhost:3306/secretepdb";
    	    String username = "root";
    	    String password = "admin";
    	    Connection conn = null;
    	    Statement stmt = null;  	    
    	     String func=null;    	     
    	     String uniprotId=null;
    	    String filepath="F:\\Google Drive\\Server_Paper\\data\\database_data\\T3\\T3_uniprot/";
    	    String sql="";
    	 try {       
    		   Class.forName(driver);    
    		   conn = DriverManager.getConnection(url, username, password);
    		   stmt = conn.createStatement();
               System.out.print("yes");
         } catch (Exception e) {
             System.out.print("MYSQL ERROR:" + e.getMessage());
         }
    	 try{
    		 File file = new File(filepath);
    		 System.out.println(file.list().length);
    		 if (file.isDirectory()) {     
                 String[] filelist;
                 filelist= new String[file.list().length];
                 filelist=file.list();
                 for (int i = 0; i < filelist.length; i++) {               	
                	 String sequence="";    
             	     String names="";
             	     String name="";
            	     String molecalarweight="";
            	     String length="";
            	     String alt="";
            	     String organism="";
            	     String gene="";
            	     String function="";
            	     String function1="";
            	     String evidence="";
            	     String str="";
            	     int end=0;
            	     String go_1="";
            	     String go="";
            	     String os_1="";
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 String ss=readfile.getName();                        	 
                        	 uniprotId=ss.substring(0, ss.indexOf("."));;//表Protein中UniprotID
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 boolean isName = true;
                        	 String s = null;
                        	 while((s = br.readLine()) != null){               	  
                            	 if(s.startsWith("DE")){ 
                            		 String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                            		 String[] name1 = qq.split("\\*");   
                            		 String name2=name1[1];
                            		 if(name2.contains(";")){
                            			 str=name2.substring((name2.indexOf("=")+"=".length()), name2.indexOf(";"));//表protein中Name的值
                            			 if(str.contains("{")){
                            				 str=str.substring(0,str.indexOf("{"));
                            			 }
                            		 }
                            		 if(isName){                   			
                            			 name=str;                      		 
                                 		 isName = false;
                            		 }                            		                        		                     			
                                		 names=names+str+";";//表protein中AllName的值                  		                       		                     			                        		                  		 
                            	} 
                            	 else if(s.startsWith("DR")){                    		
                             		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                             		 String[] strss = qq.split("\\*");
                             		 if(strss[1].contains("GO;")){
                             			  go=strss[1].substring(strss[1].indexOf(";")+2,14);
                             			 go_1=go_1+go+"===";
                             		 }
                             		 if(go_1.endsWith("=")){
                             			 evidence=go_1.substring(0, go_1.lastIndexOf("=")-2);
                             		 }
                             		 
                             	}
                             	else if(s.startsWith("SQ")){                    		
                            		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*
                            		 String[] Mole = qq.split("\\*");                    		
                            		 String Moleca=Mole[3];
                            		 molecalarweight=Moleca.substring(0, Moleca.indexOf("M"));//表protein中MolecalarWeight的值
                            		 String Len=Mole[2];
                            		 length=Len.substring(0, Len.indexOf("A"));//表protein中MolecalarWeight的值                      		
                            	}
                            	else if(s.startsWith("AC")){
                            		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*                   		
                            		String[] alt1= qq.split("\\*"); 
                            		alt=alt1[1];//表Protein中altUniprotACC的值
                            	}
                            	else if(s.startsWith("OS")){
                            		os_1+=s;
                            	}
                            	else if(s.startsWith("GN")){
                            		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*                   		
                            		String[] gn= qq.split("\\*");  
                            		String ge=gn[1];
                            		if(ge.contains("{")){
                            			gene=ge.substring((ge.indexOf("=")+"=".length()), ge.indexOf("{")-1);
                            		}
                            		else{
                            			gene=ge.substring((ge.indexOf("=")+"=".length()), ge.indexOf(";"));//表protein中Gene的值                    		
                            		}
                            		
                            	}  
                            	else if(s.startsWith(" ")){
                            		sequence+=s;    
                                    sequence = sequence.replaceAll(" +","");//去掉所有空格             			
                            		}
                            	/*else if(s.startsWith("CC")){                            		
                            		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*                   		
                            		String[] fu= qq.split("\\*");  
                            		String fun=fu[1];                      		 
                            		func=func+fun;                    		
                            	}*/                            	 
                            	else if(s.startsWith("CC")){                            		                           		                            		
                            		function1+=s;                            		                            		         		                            		
                            	}
                            	} 
                         }	
                         String oos = os_1.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*                   		
                         String[] org= oos.split("\\*");
                         if(org[1].contains("(")){
                        	 organism=org[1].substring(0,org[1].indexOf("("));
                         }
                         else{
                        	 organism=org[1];
                         }
                         if(function1.contains("FUNCTION")){                           			 
                        	 String fun1 = function1.replaceAll("CC {2,}", " ");//把字符串s中的多个空格替换为*   
                        	 int begin=fun1.indexOf(":");
                        	 if(fun1.contains("{")){
                        		 end=fun1.indexOf("{");
                        	 }
                        	 else{
                        		 end=fun1.indexOf(".");
                        	 }
                        	  //end=fun1.indexOf("{");
                        	 function=fun1.substring(begin+2,end);  
                        	 
                         }    
                         System.out.println(gene);
                        /*System.out.println(evidence);//表protein中Name的值
                        System.out.println(names);  
                        System.out.println(function);
                        System.out.println(sequence);//表protein中Sequence的值
                        System.out.println(name);//表protein中Name的值
                        System.out.println(names);  //表protein中allNames的值
                        System.out.println(molecalarweight);//表protein中的值
                        System.out.println(length);//表protein中Length的值
                        System.out.println(alt);//表protein中altUniprotAcc的值
*/                       // System.out.println(organism);//表protein中Organism的值
                        //System.out.println(gene);//表protein中Gene的值                                                               		
         			  sql = "insert into protein(UniprotID,Name,Evidence,MolecularWeight,Function,Sequence,Length,altUniprotACC,DBid,Organism,Gene,allNames,flagType)values"
         						+ "(\""+ uniprotId +"\",\""+name+"\",\""+evidence+"\",\""+molecalarweight+"\",\""+function+"\",\""+sequence+"\",\""+length+"\",\""+alt+"\",\"\",\""+organism+"\",\""+gene+"\",\""+names+"\",\"T3_uniprot\")";
         				stmt.execute(sql);
                 		// br.close();
                 }	    	    
			 }          
    	 }catch(Exception e){
    		 System.out.println(e);
    		 
    	 	}
    }
}
