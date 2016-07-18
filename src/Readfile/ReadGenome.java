package Readfile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ReadGenome {
    public static void main(String[] args) throws IOException {       
    	   BufferedReader br = null;
    	   int m = 0;
    	   String str=null;
    	   String[] cds=null;
    	   File file = new File("C:\\Users\\yia\\Google Drive\\Information\\Genome-Jon\\B5055-protein.fasta");
    	   FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
    	   BufferedWriter bw = new BufferedWriter(fw);
    	    		 String[] aa=null;
    	    		 try{
    	    			 br = new BufferedReader(new FileReader("C:\\Users\\yia\\Google Drive\\Information\\Genome-Jon\\B5055 genome.gbk"));
    	    			 String s = null;
    	    			 while((s = br.readLine()) != null){
    	    				 if(s.startsWith("CDS")){
    	    					 BufferedWriter bwcopy = br.;
    	    					 
    	    				 }
    	    			 }
    	              br.close();
    	         }catch(Exception e){       
    	    	}

    	    }
    	
    }

