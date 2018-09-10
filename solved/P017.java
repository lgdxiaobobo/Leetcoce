import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if (digits.length() == 0) return res;
        HashMap<Integer, String> tmp = new HashMap<Integer, String>();
        tmp.put(1, "*");
        tmp.put(2, "abc");
        tmp.put(3, "def");
        tmp.put(4, "ghi");
        tmp.put(5, "jkl");
        tmp.put(6, "mno");
        tmp.put(7, "pqrs");
        tmp.put(8, "tuv");
        tmp.put(9, "wxyz");
        probStr("", digits, res, tmp);
        return res;
    }
    
    private void probStr(String str, String digits, List<String> res, HashMap<Integer, String> tmp){
        if (digits.length() == 0) res.add(str);
        else{
            int num = digits.charAt(0) - 48;
            char[] prob = tmp.get(num).toCharArray();
            for (char x: prob){
                probStr(str + x, digits.substring(1), res, tmp);
            }
        }
    }
}