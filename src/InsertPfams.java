import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsertPfams
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		File file = new File("F:/Data/T3/T3.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str!=null)
		{
			String[] id1=str.split("\t");
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
		
		File out = new File("C:/Users/yia/Data/T3_blast/" + id + ".fasta");
		if(!out.exists())
		{
			
			System.out.println(out);
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);
			String url = "http://www.uniprot.org/uniprot/" + id +".txt";
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
