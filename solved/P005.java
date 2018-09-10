public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        char[] tmp = s.toCharArray();
        
        int len = 1;
        int start = 0;
        
        for (int i = 0; i < tmp.length; i ++){
            int l = 0;
            while(i - l >= 0 && i + l < tmp.length && tmp[i-l] == tmp[i+l]) l ++;
            if (i + l >= tmp.length || i - l <= 0 || tmp[i-l] != tmp[i+l]) l--;
            if (len < 2 * l + 1){
                start = i - l;
                len = l * 2 + 1;
            }
            l = 0;
            while(i - l >= 0 && i + 1 + l < tmp.length && tmp[i-l] == tmp[i+1+l]) l ++;
            if (i + 1 + l >= tmp.length || i - l <= 0 || tmp[i-l] != tmp[i+l+1]) l--;
            if (len < 2 * l + 2){
                start = i - l;
                len = 2 * l + 2;
            }
        }
        return s.substring(start, start + len);
    }
}