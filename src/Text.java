import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.net.URL; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
 
public class Text { 
    public static void main(String[] args) throws Exception { 
        URL url = new URL("http://pfam.xfam.org/protein/P13835"); 
        InputStreamReader reader = new InputStreamReader(url.openStream()); 
        BufferedReader br = new BufferedReader(reader); 
        String s = null; 
        while((s=br.readLine())!=null){ 
        	String ss = "<td class='pfam_PF05394'>([^<>]*)</td>";   //多行模式
            Pattern pa = Pattern.compile(ss); 
            Matcher ma =  pa.matcher(s); 
            if(ma.find()){ 
            	for (int i = 1; i<= ma.groupCount(); i++) {
            		System.out.println(ma.group(i));
            		}
            } 
            
        } 
        br.close(); 
        reader.close(); 
    } 
} 

