import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 * @author yia
 *根据Uniprot的注释提取时间信息
 */
public class FindDT {
    public static void main(String[] args) {       
    	     String func=null;    	     
    	     String uniprotId=null;
    	    String filepath="C:/Users/yia/Google 云端硬盘/Server_Paper\data\depedent dataset";
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
                            		 String str=name2.substring((name2.indexOf("=")+"=".length()), name2.indexOf(";"));//表protein中Name的值
                            		 if(isName){                   			
                            			 name=str;                      		 
                                 		 isName = false;
                            		 }                            		                        		                     			
                                		 names=names+str+";";//表protein中AllName的值         All Names de                 		                       		                     			                        		                  		 
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
                            		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*                   		
                            		String[] org= qq.split("\\*");  
                            		organism=org[1];
                            	}
                            	else if(s.startsWith("GN")){
                            		String qq = s.replaceAll(" {2,}", "*");//把字符串s中的多个空格替换为*                   		
                            		String[] gn= qq.split("\\*");  
                            		String ge=gn[1];
                            		gene=ge.substring((ge.indexOf("=")+"=".length()), ge.indexOf(";"));//表protein中Gene的值                    		
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
                        	// System.out.println(function1);
                        		 /*int begin=func.indexOf(":");
                        		 int end=func.indexOf("{");
                         	     function=func.substring(begin+2,end);   */                     			                        	                         	    
                         }	
                         if(function1.contains("FUNCTION")){                           			 
                        	 String fun1 = function1.replaceAll("CC {2,}", " ");//把字符串s中的多个空格替换为*   
                        	 int begin=fun1.indexOf(":");
                        	 int end=fun1.indexOf("{");
                        	 function=fun1.substring(begin+2,end);                          			
                         }    
                        System.out.println(function);
                        System.out.println(sequence);//表protein中Sequence的值
                        System.out.println(name);//表protein中Name的值
                        System.out.println(names);  //表protein中allNames的值
                        System.out.println(molecalarweight);//表protein中的值
                        System.out.println(length);//表protein中Length的值
                        System.out.println(alt);//表protein中altUniprotAcc的值
                        System.out.println(organism);//表protein中Organism的值
                        System.out.println(gene);//表protein中Gene的值                                                               		
         			   sql = "insert into protein(UniprotID,Name,Evidence,MolecularWeight,Function,Sequence,Length,altUniprotACC,DBid,Organism,Gene,allNames,flagType)values"
         						+ "(\""+ uniprotId +"\",\""+name+"\",\"\",\""+molecalarweight+"\",\""+function+"\",\""+sequence+"\",\""+length+"\",\""+alt+"\",\"\",\""+organism+"\",\""+gene+"\",\""+names+"\",\"T3_blast\")";
         				stmt.execute(sql);
                 		// br.close();
                 }	    	    
			 }          
    	 }catch(Exception e){
    		 System.out.println(sql);
    		 
    	 	}
    }
}
