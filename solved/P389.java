public class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < 26; i ++){
            cnt1[i] = 0;
            cnt2[i] = 0;
        }

        for (char x: s.toCharArray()){
            cnt1[x - 'a'] += 1;
        }
        for (char x: t.toCharArray()){
            cnt2[x - 'a'] += 1;
        }

        for (int i = 0; i < 26; i ++){
            if (cnt1[i] < cnt2[i]){
                char x = (char)(i + 'a');
                return x;
            }
        }
        return 'a';
    }
}