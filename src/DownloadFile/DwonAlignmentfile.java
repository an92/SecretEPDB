package DownloadFile;
/**
 * This is for downloading the fasta files in a new file
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DwonAlignmentfile
{
	static String name="";
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		String filepath_align="C:/Users/yia/Data/Align/T6_Align/";
		try{
	   		 File file = new File(filepath_align);
	   		 System.out.println(file.list().length);
	   		if (file.isDirectory()) {     
                String[] filelist;
                filelist= new String[file.list().length];
                filelist=file.list();
                for (int i = 0; i < filelist.length; i++) { 
                 	File readfile = new File(filepath_align + "\\" + filelist[i]); 
                 	System.out.print(file);
                    if (!readfile.isDirectory())  {
                    	FileReader fr = new FileReader(readfile);
                		BufferedReader br = new BufferedReader(fr);
                		String str = br.readLine();
                		while(str!=null)
                		{
                			 String ss=readfile.getName(); 
                          	 name=ss.substring(0, ss.indexOf("."));
                          	 
                			 String[] id1=str.split("\n");
                			for(int m=0;m<id1.length;m++){
                				 String id=id1[0];
                				System.out.println(id);
                				downloadFasta(id);				
                				str = br.readLine();
                			}
                		}
                		br.close();
                		fr.close();
                    }
                }
	   		}
		}catch(Exception e){
	   		 System.out.println(e);
	   	 	}
	}
	public static void downloadFasta(String id) throws Exception
	{
		
		File out = new File("C:/Users/yia/Data/Align/T6_aln_1/" + name + ".fasta");
			//System.out.println(out);
			FileWriter fw = new FileWriter(out,true);
			BufferedWriter bw = new BufferedWriter(fw);
			String url = "http://www.uniprot.org/uniprot/" + id +".fasta";
			//System.out.println(url);
			URL U = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)U.openConnection();
			connection.connect();			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine())!= null)
			{
				bw.write(line + "\n");
				bw.flush();
			}
			bw.close();
			fw.close();
			in.close();
		}
}
