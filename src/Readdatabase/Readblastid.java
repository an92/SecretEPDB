/**
 * 该文件是从blast后出现的多序列文件，并从该文件中读取不同的UniProt ID进行下载到一个文件中,实现多序列比对的基础文件。
 */
package Readdatabase;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Readblastid
{
	static String name="";

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		String filepath="C:\\Users\\yia\\Google Drive\\append\\Aln\\";
		File file = new File(filepath);
		 if (file.isDirectory()) {     
			 String[] filelist;
			 filelist= new String[file.list().length];
			 filelist=file.list();
			 for (int i = 0; i < filelist.length; i++) { 
				 File readfile = new File(filepath + "\\" + filelist[i]); 
				 if (!readfile.isDirectory())  {
					 BufferedReader  br = new BufferedReader(new FileReader(readfile));
					 String ss=readfile.getName();   
					 System.out.println(ss);
					 name=ss.substring(0, ss.indexOf("."));
					 String s = null;
                	 while((s = br.readLine()) != null){ 
                			 String id=s;
                			 System.out.println(id);
                			 downloadFasta(id);				
				}
                	 }
				 }
			 }
		 }

	public static void downloadFasta(String id) throws Exception
	{
		
		File out = new File("C:\\Users\\yia\\Google Drive\\append\\Aln_fasta\\" + name + ".fasta");
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
	
