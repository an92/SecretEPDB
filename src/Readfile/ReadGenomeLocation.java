package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author yia
 *该程序是读出Genome文件中预测出来的蛋白质信息，并在其原来的文件中找到其对应的起始末尾位置,>后有location的信息
 */
public class ReadGenomeLocation {
	public static void main(String[] args) throws IOException {       
    	   BufferedReader br = null;
    	   File file = new File("F:\\yia\\Google Drive\\Circos\\data\\MGH78578.txt");
    	   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
    	   BufferedWriter bw = new BufferedWriter(fw);
    	    		 try{
    	    			 	File f = new File("F:\\yia\\Google Drive\\Circos\\data\\MGH78578_T4SE_NonSignalP.fasta");
    	    				FileInputStream fin;
    	    				fin = new FileInputStream(f);
    	    				InputStreamReader inputStreamReader = new InputStreamReader(fin);
    	    				BufferedReader read = new BufferedReader(inputStreamReader);
    	    				String lineContent = "";
    	    				String s = "";
    	    				BufferedReader newread;
    	    				while ((lineContent = read.readLine()) != null) {
    	    					if (lineContent.startsWith(">")) {
    	    						if (lineContent.contains("complement")){
        	    						s = lineContent.substring(lineContent.indexOf("location=complement(")+20,lineContent.lastIndexOf(")"));
    	    						}
    	    						else {
        	    						s = lineContent.substring(lineContent.indexOf("location=")+9,lineContent.lastIndexOf("]"));
    	    						}
    	    						bw.write(s);
    	    						bw.newLine();
    	    						bw.flush();
    	    					}
    	    						//System.out.println(s);
    	    					}
    	    					
    	              br.close();
    	              read.close();
    	         }catch(Exception e){       
    	    	}

    	    }
    }




