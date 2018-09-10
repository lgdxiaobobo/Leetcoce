import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public void getPossibleIP(String s, String tmp, List<String> res, int index){
        if (index == 3){
            if (s.length() > 0 && s.length() <= 3 && Integer.valueOf(s) <= 255 && (s.length() == 1 || !s.startsWith("0"))){
                res.add(tmp + s);               
            }
        }
        else{
            for (int i = 3; i > 0; i --){
                if (s.length() < i) continue;
                String sub = s.substring(0, i);
                if (Integer.valueOf(sub) <= 255 && (sub.length() == 1 || !sub.startsWith("0"))){
                    getPossibleIP(s.substring(i), tmp + sub + ".", res, index + 1);
                }
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        String tmp = "";
        getPossibleIP(s, tmp, res, 0);        
        return res;
    }
}