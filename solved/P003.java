import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        char[] tmp = s.toCharArray(); 
        int result = 0;
        int lastID = -1;
        HashMap<Character, Integer> delta = new HashMap<Character, Integer>();
        
        for (int i = 0; i < tmp.length; i ++){
            if (!delta.containsKey(tmp[i])){
                delta.put(tmp[i], i);
                if (result < i - lastID){
                    result = i - lastID;
                }
            }
            else{
                if (lastID  < delta.get(tmp[i])){
                    lastID =delta.get(tmp[i]);
                }
                if (result < i - lastID) result = i - lastID;
                delta.put(tmp[i], i);
            }
        }
        return result;
    }
}