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
    	 String strs_1=null;
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
                            	 }
                            }  
                 }
    		 }
    		 if(strs.contains("type IV secretion system")){
        		 //not = strs.replaceAll("CC {2,}", " ");//把字符串中的多个空格替换为*
        		 System.out.println(name);
            	/* int begin=not.indexOf("Note");
            	 int end=not.indexOf("{");
            	 strs_1=not.substring(begin+2,end);   */
            	 //System.out.println(name+strs_1);
             }	    
    	 }catch(Exception e){  
    		 System.out.println(e);
    	 	}
    }
}
