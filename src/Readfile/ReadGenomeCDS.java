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
 *该程序是读出Genome文件中蛋白质位置的信息
 */
public class ReadGenomeCDS {
	public static void main(String[] args) throws IOException {       
    	   BufferedReader br = null;
    	   File file = new File("F:\\yia\\Google Drive\\Circos\\data\\AJ218_CDS.fasta");
    	   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
    	   BufferedWriter bw = new BufferedWriter(fw);
    	    		 try{
    	    			 File f = new File("F:\\yia\\Google Drive\\Circos\\data\\AJ218 genome.gbk");
    	    				FileInputStream fin;
    	    				fin = new FileInputStream(f);
    	    				InputStreamReader inputStreamReader = new InputStreamReader(fin);
    	    				BufferedReader read = new BufferedReader(inputStreamReader);
    	    				String lineContent = "";
    	    				String s = "";
    	    				String locus_tag="";
    	    				String cds="";
    	    				BufferedReader newread;
    	    				while ((lineContent = read.readLine()) != null) {
    	    					if (lineContent.startsWith("     CDS")) {
    	    						read.mark((int)file.length());// 设置文件标志位 
    	    						newread = read;
    	    						s = lineContent;
    	    						String text = "";
    	    						while (!(text = newread.readLine()).startsWith("     CDS")) {
    	    							s += text;
    	    						}
    	    						read=newread;
    	    						read.reset();;  
    	    						int taginx=s.indexOf("tag=")+5;
    	    						/*locus_tag=s.substring(taginx, taginx+14);
    	    	    				inference=s.substring(s.indexOf("inference=")+11,s.indexOf("inference=")+45);*/
    	    						locus_tag=s.substring(taginx, taginx+18);
    	    						if(s.contains("complement(")){
    	    	    					cds=s.substring(s.indexOf("complement(")+11,s.indexOf(")"));
    	    	    				}
    	    						else{
        	    	    				cds = s.substring(21,s.indexOf("/"));
    	    						}
    	    						System.out.println(cds);
    	    						//bw.write(">"+locus_tag+"|"+inference+"|"+inference_1+"|");
    	    						//bw.newLine();
    	    						//bw.write(sequence);
    	    						//bw.newLine();
    	    						//bw.flush();
    	    						//System.out.println(inference);
    	    						//System.out.println(inference_1);
    	    						//System.out.println(s.substring(s.lastIndexOf("CDS"),s.indexOf("Big")));
    	    						//System.out.println(s.substring(s.indexOf("Test")));
    	    					}
    	    					
    	    				}
    	              br.close();
    	              read.close();
    	         }catch(Exception e){       
    	    	}

    	    }

    }




