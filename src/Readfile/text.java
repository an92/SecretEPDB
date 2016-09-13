package Readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class text {
	 public static void main(String[] args) throws Exception{
	 
	// 初始化list
		 BufferedReader br = null;
		 List<Integer> list = new ArrayList<Integer>();
		 try{
			 br = new BufferedReader(new FileReader("F:\\yia\\Google Drive\\SecretEPDB\\NewData\\T4SE\\T4SE_seq_1.txt"));
			 String s = null;
			 String ss[] = null;
			
			 while((s = br.readLine()) != null){
				 ss=s.split(",");
				 for(int i=0;i<list.size();i++){
					 list.add(Integer.valueOf((ss[i])));
				 }
			 }
		 }catch(Exception e){  
		    	 System.out.println(e);
		     }
    // set中存放的是不可重复的元素
    HashSet<Integer> set = new HashSet<Integer>();
    // 这里存放的是所有重复的元素，如果你只想知道是哪几个数字重复了，不需要知道具体重复了几次，可以用HashSet
    List<Integer> repeatElements = new ArrayList<Integer>();
    for (int i=0;i<list.size();i++) {
        int value = list.get(i);
        if (set.contains(value)) {
            // 重复元素
            repeatElements.add(value);
        }
        else {
            set.add(value);
        }
    }
    // 输出重复的元素
    for (int i=0;i<repeatElements.size();i++) {
        System.out.println(repeatElements.get(i));
    }
}
}
