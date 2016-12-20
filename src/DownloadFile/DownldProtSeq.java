package DownloadFile;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yia
 * 从Genbank中找到有pdb 文件的id号。
 *
 */
public class DownldProtSeq
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		File file = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\NCBI_id.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str!=null)
		{
			String[] id1=str.split("\r\n");
			for(int i=0;i<id1.length;i++){
				String id=id1[i];
				downloadpdb(id);				
				System.out.println(i);
				str = br.readLine();
			}
		}
		br.close();
		fr.close();
	}

	public static void downloadpdb(String id) throws Exception
	{
		
		File out = new File("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\NCBI_id_pdb.txt");
		if(!out.exists())
		{
			
			int n=0;
			System.out.println(out);
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			String url="https://www.ncbi.nlm.nih.gov/protein/"+id+"";
			System.out.println(url);
			URL U = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)U.openConnection();
			connection.connect();			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			String pdb=null;
			while ((line = in.readLine())!= null)
			{
				if(line.contains("<div>PDB:")){
					pdb=line.substring(line.indexOf("<div>PDB")+2,line.indexOf("</div>"));
				}
				System.out.println(line);
				n++;
				System.out.println(n);
				//bw.write(pdb + "\n");
				//bw.flush();
			}
			bw.close();
			fw.close();
			in.close();
		}
	}
	
}
