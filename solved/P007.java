public class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            if (x < -Integer.MAX_VALUE) return 0;
            x = -x;
        }
        if (x < 10) return sign * x;
        else{
            int result = 0;
            while (x > 0){
                if (result > Integer.MAX_VALUE / 10) return 0;
                result = result * 10 + x % 10;
                x /= 10;
            }
            return sign * result;
        }
    }
}