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
		File file = new File("F:\\yia\\pdb_id.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str!=null)
		{
			String[] id1=str.split("\n");
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
		
			
			String url="http://www.rcsb.org/pdb/images/"+id+"_bio_r_500.jpg";
			System.out.println(url);
			URL U = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)U.openConnection();
			connection.connect();			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			InputStream inputStream = connection.getInputStream();   //通过输入流获得图片数据 
		    byte[] getData = readInputStream(inputStream);     //获得图片的二进制数据 
		        File imageFile = new File("F:\\pdb\\" + id + ".jpg");   
		        FileOutputStream fos = new FileOutputStream(imageFile);    
		        fos.write(getData); 
		        fos.close(); 
		              
		    } 
		      
       public static  byte[] readInputStream(InputStream inputStream) throws IOException { 
		        byte[] buffer = new byte[1024]; 
		        int len = 0; 
		        ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		        while((len = inputStream.read(buffer)) != -1) { 
		            bos.write(buffer, 0, len); 
		        } 
		              
		        bos.close(); 
		        return bos.toByteArray(); 
	}
	
}
