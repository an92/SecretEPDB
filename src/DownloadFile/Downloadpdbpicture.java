package DownloadFile;
/**
 * This is for downloading the pdb picture files 
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloadpdbpicture
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		File file = new File("C:/Users/yia/Data/PDBs/PDBs.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str!=null)
		{
			String[] id1=str.split(" ");
			for(int i=0;i<id1.length;i++){
				String id=id1[i];
				downloadPdb(id);				
				System.out.println(i);
				str = br.readLine();
			}
		}
		br.close();
		fr.close();
	}

	public static void downloadPdb(String id) throws Exception
	{
		
		File out = new File("C:/Users/yia/Data/PDBs/PDB_picture/" + id + "");
		if(!out.exists())
		{
			
			System.out.println(out);
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			String url="http://www.rcsb.org/pdb/images/"+id+"_bio_r_500.jpg";
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
