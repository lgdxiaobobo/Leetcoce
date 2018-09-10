public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        
        char[] tmp = s.toCharArray();
        String result = "";
        
        for (int i = 0; i < numRows; i ++){
            if (i == 0 || i == numRows - 1){
                for (int k = 0; k * (numRows - 1) * 2 + i < tmp.length; k ++){
                    result += tmp[i + 2 * k * (numRows - 1)];
                }
            }
            else{
                for (int k = 0; k * (numRows - 1) * 2 + i < tmp.length; k ++){
                    result += tmp[i + 2 * k * (numRows - 1)];
                    if (i + 2 * k * (numRows - 1) + 2 * (numRows - i - 1) < tmp.length){
                        result += tmp[i + 2 * k * (numRows - 1) + 2 * (numRows - i - 1)];
                    }
                }
            }
        }
        return result;
    }
}