package Readfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadOrder
{
	public static void main(String[] args) throws Exception
	{
		
		 File file = new File("F:/yia/Google Drive/SecretEPDB/NewData/MysqlFile/Secretepdb.fasta");
		 FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		File file_ori = new File("F:/yia/Google Drive/SecretEPDB/NewData/MysqlFile/T3_uniprot.fasta");
		try{
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\MysqlFile\\T3_sql.txt"));
			 String s = null;
			while((s = br.readLine()) != null){
					  String ss[] = s.split(",");
					  BufferedWriter bw = new BufferedWriter(fw);
					  String rl = null;
					  //System.out.print(s);
				for(int i=0;i<ss.length;i++){
					BufferedReader br2 = new BufferedReader(new FileReader(file_ori));
					while(( rl = br2.readLine()) != null)
					{
						if (rl.contains(ss[i])) {
							bw.write(rl + "\r");
							bw.write(br2.readLine() + "\r");
							bw.flush();
						}
					}
				}
				
			}
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
