package DownloadFile;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yia
 * 从Genbank中找到有pdb 文件的id号。
 *
 */
public class DownPdbFromNcbi
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
//				System.out.println(i);
				str = br.readLine();
			}
		}
		br.close();
		fr.close();
	}

	public static void downloadpdb(String id) throws Exception
	{
		
		 BufferedReader br = null;  
		 FileOutputStream fos = null;  
		 OutputStreamWriter osw = null;  
		 String inputLine;  
		 String pdb=null;
		try {  
		      URL url = null;  
		      url = new URL("https://www.ncbi.nlm.nih.gov/structure?Db=structure&DbFrom=protein&Cmd=Link&IdsFromResult="+id);  
		      // 通过url.openStream(),来获得输入流  
//		      url = new URL("https://www.ncbi.nlm.nih.gov/structure?Db=structure&DbFrom=protein&Cmd=Link&IdsFromResult=52841911");
//		      System.out.println(url.getQuery());
		       br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));  
		       File file = new File("download.html");  
		       fos = new FileOutputStream(file);  
		       osw = new OutputStreamWriter(fos, "utf-8");  
		      // 将输入流读入到临时变量中，再写入到文件  
			while ((inputLine = br.readLine()) != null) {
				osw.write(inputLine);
				if (inputLine.contains("PDB ID: </dt><dd>")) {
					pdb = inputLine.substring(inputLine.indexOf("PDB ID: </dt><dd>")+17,inputLine.indexOf("PDB ID: </dt><dd>")+21);
				System.out.println(id+inputLine);
				}
			}
//			System.out.println(pdb);
			br.close();
			osw.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
		                if (br != null && osw != null) {  
		                    br.close();  
		                    osw.close();  
		                }  
		            } catch (IOException e) {  
		                e.printStackTrace();  
		            }  
		        }  
			}		  

		}

