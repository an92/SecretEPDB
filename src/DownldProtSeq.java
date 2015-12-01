/**
 * This is for downloading the fasta files 
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownldProtSeq
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		File file = new File("C:/Users/yia/Data/T4data/T4_paper.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str!=null)
		{
			//str = str.trim();
			String[] id1=str.split("\t");
			//String id = str.split("\t");
			//System.out.println(id);
			for(int i=0;i<id1.length;i++){
				String id=id1[i];
				downloadFasta(id);				
				System.out.println(i);
				str = br.readLine();
			}
		}
		br.close();
		fr.close();
	}

	public static void downloadFasta(String id) throws Exception
	{
		
		File out = new File("C:/Users/yia/Data/T4data/T4_paper/" + id + ".fasta");
		if(!out.exists())
		{
			
			System.out.println(out);
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			String url="http://www.ncbi.nlm.nih.gov/protein/"+id+"?report=fasta";
			//String url = "http://www.uniprot.org/uniprot/" + id +".txt";
			System.out.println(url);
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
	
}
