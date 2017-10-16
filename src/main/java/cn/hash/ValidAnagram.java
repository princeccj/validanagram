package cn.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Bowei Liu on 2017/10/16.
 */
public class ValidAnagram {
    public static void main(String[] args) {

        System.out.println(validAnagram("assas","sasaa"));
    }

    public static boolean validAnagram(String s , String t){
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
        if (s.length()!=t.length()){
            System.out.println("NO");
            return false;
        }else{
            for (int i = 0 ; i < s.length() ; i++){
                if (hashMap.containsKey(s.charAt(i))){
                    hashMap.put(s.charAt(i),(hashMap.get(s.charAt(i))+1));
                }else {
                    hashMap.put(s.charAt(i),1);
                }
            }

            for (int j = 0 ; j < t.length() ; j++){
                if (hashMap.containsKey(t.charAt(j))&&hashMap.get(t.charAt(j))!=0){
                        hashMap.put(t.charAt(j),(hashMap.get(t.charAt(j))-1));
                }
            }

        }
        int l = 0 ;
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+"\t"+entry.getValue());
            l += (Integer) entry.getValue();
        }

        if(l != 0){
            return false;
        }else{
            return true;
        }

    }
}
