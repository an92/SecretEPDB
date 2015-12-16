/**
 * This is for downloading the fasta files 
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class text_1
{
	static String name="";

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		File file = new File("G:/T3_Align/Q9RPM6.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		
		while(str!=null)
		{
			 String ss=file.getName();                        	 
          	 name=ss.substring(0, ss.indexOf("."));
			 String[] id1=str.split("\n");
			for(int i=0;i<id1.length;i++){
				String id=id1[0];
				System.out.println(id);
				downloadFasta(id);				
				str = br.readLine();
			}
		}
		br.close();
		fr.close();
	}

	public static void downloadFasta(String id) throws Exception
	{
		
		File out = new File("G:/T3_aln_1/" + name + ".fasta");
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
	
