import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author yia
 * 读取note.判定是否是type4的protein.
 *
 */
public class Readnote {
    public static void main(String[] args) {       
    	 String filepath="C:/Users/yia/Google 云端硬盘/type4 re";
    	 String not=null;
    	 String[] str=null;
    	 String name=null;
    	 String strs=null;
    	 try{
    		 File file = new File(filepath);  
    		 if (file.isDirectory()) {     
                 String[] filelist = file.list();   
                 for (int i = 0; i < filelist.length; i++) {  
                	 File readfile = new File(filepath + "\\" + filelist[i]);                         
                         if (!readfile.isDirectory())  {
                        	 BufferedReader  br = new BufferedReader(new FileReader(readfile));
                        	 String s = null;
                        	 name=readfile.getName();
                        	 while((s = br.readLine()) != null){
                            	 if(s.startsWith("CC")){     
                            			  strs+=s;
                                		 }
                            	 System.out.println(strs);
                            	 }
                            }  
                         if(strs.contains("Note")){
                    		 System.out.println(name);
                    		 not = strs.replaceAll("CC {2,}", " ");//把字符串s中的多个空格替换为* 
                    		 /*str=not.split("\\*");
                    		 if(str[1].contains("Type")){
                    			 System.out.println(name);
                    		 }*/
                         }	                        
                 }
    		 }
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
