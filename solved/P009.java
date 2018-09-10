public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 && x < -Integer.MAX_VALUE) return false;
        if (x < 0) return false;
        if (x < 10) return true;
        int base = 1;
        while(base <= x / 10) base *= 10;
        boolean flag = true;
        while(x > 0){
            int left = x / base;
            int right= x % 10;
            if (left != right){
                flag = false;
                break;
            }
            x = x % base / 10;
            base /= 100;
        }
        return flag;
    }
}