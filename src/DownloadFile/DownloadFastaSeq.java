package DownloadFile;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yia
 * 从UnipProt 中下载fasta文件。
 *
 */
public class DownloadFastaSeq
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T3SE\\Bean2.0.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		
		while(str!=null)
		{
			//str = str.trim();
			String[] id1=str.split("\r");
			//String id = str.split("\t");
			//System.out.println(id);
			for(int i=0;i<id1.length;i++){
				String id=id1[i];
				downloadFasta(id);				
				System.out.println(i);
				str = br.readLine();
			}
		}
    		/* br_write = new BufferedReader(new FileReader("F:\\Google Drive\\SecretEPDB\\NewData\\T3SE\\fasta\\24391954.fasta"));
			 String s = null;
			 while((s = br.readLine()) != null){
				 if(s.startsWith(">")){
					 bwwrite.write(content);
					 //bw.newLine();
					 bw_write.flush();	 
					
				 }*/
		br.close();
		fr.close();
	}

	public static void downloadFasta(String id) throws Exception
	{
		
		File out = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T3SE\\fasta\\" + id + ".txt");
		if(!out.exists())
		{
			
			System.out.println(out);
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			//String url="http://www.ncbi.nlm.nih.gov/protein/"+id+"?report=fasta";
			String url = "http://www.uniprot.org/uniprot/" + id +".fasta";
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
