public class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> charCnt = new HashMap<Character, Integer>();
        
        char[] tmp = s.toCharArray();
        
        for (Character x: tmp){
            if (!charCnt.containsKey(x)) charCnt.put(x, 1);
            else charCnt.put(x, charCnt.get(x) + 1);
        }
        
        String result = "";
        HashSet<Character> isExist = new HashSet<Character>();
        
        for (Character x: tmp){
            charCnt.put(x, charCnt.get(x)-1);
            if (isExist.contains(x)) continue;
            for (int i = result.length() - 1; i >= 0; i --){
                char ch = result.charAt(i);
                if (ch > x && charCnt.get(ch) > 0){
                    isExist.remove(ch);
                    if (i <= 0) result = result.substring(i + 1);
                    else if (i + 1 == result.length()) result = result.substring(0, i);
                    else result = result.substring(0, i) + result.substring(i + 1);
//                  i = i - 1;
                }
                else break;             
            }
            isExist.add(x);
            result += x;
        }
        
        return result;
    }
}