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
 *该程序是读出Genome文件中蛋白质的信息,部分annotation信息
 */
public class ReadGenome {
	public static void main(String[] args) throws IOException {       
    	   BufferedReader br = null;
    	   File file = new File("F:\\yia\\Google Drive\\Circos\\data\\B5055.fasta");
    	   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
    	   BufferedWriter bw = new BufferedWriter(fw);
    	    		 try{
    	    			 File f = new File("F:\\yia\\Google Drive\\Bastion4\\Genome\\AJ218 genome.gbk");
    	    				FileInputStream fin;
    	    				fin = new FileInputStream(f);
    	    				InputStreamReader inputStreamReader = new InputStreamReader(fin);
    	    				BufferedReader read = new BufferedReader(inputStreamReader);
    	    				String lineContent = "";
    	    				String s = "";
    	    				String locus_tag="";
    	    				String inference="";
    	    				String inference_1="";
    	    				String sequence="";
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
    	    	    				inference=s.substring(s.indexOf("inference=")+11,s.indexOf("inference=")+45);
    	    	    				inference_1=s.substring(s.lastIndexOf("inference=")+11,s.lastIndexOf("inference=")+49);
    	    	    				sequence=s.substring(s.indexOf("translation=")+13,s.lastIndexOf("\"")).replace(" ", "");
    	    	    				//sequence=;*/
    	    	    				if(inference.contains("\"")){
    	    	    					inference=inference.substring(0, inference.indexOf("\""));
    	    	    				}
    	    	    				else if(inference_1.contains("\"")){
    	    	    					inference_1=inference_1.substring(0, inference_1.indexOf("\""));
    	    	    				}
    	    						System.out.println(s);
    	    						/*bw.write(">"+locus_tag+"|"+inference+"|"+inference_1+"|");
    	    						bw.newLine();
    	    						bw.write(sequence);
    	    						bw.newLine();
    	    						bw.flush();*/
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
	
    	
	/*try {
		File f = new File("./Runlog.log");
		FileInputStream fin;
		fin = new FileInputStream(f);
		InputStreamReader inputStreamReader = new InputStreamReader(fin);
		BufferedReader read = new BufferedReader(inputStreamReader);
		String lineContent = "";
		String s = "";
		BufferedReader newread=new BufferedReader(read);
		int flg=-1;
		while ((lineContent = read.readLine()) != null) {
			if (lineContent.startsWith("processing:")) {
				if (flg == -1) {
					flg = 0;
				}else if(flg==0){
					//do something
					
					System.out.println(s);
					s = "";
				}
			}
			if (flg == 0) {
				s+=lineContent;
			}
		}
		//do something
		
		System.out.println(s);
		
		
		read.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/ //另一种读出CDS片段的方法

    }




