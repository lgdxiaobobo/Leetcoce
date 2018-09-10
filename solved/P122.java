public class Solution {
    public int maxProfit(int[] prices){
        if (prices.length <= 1) return 0;
        int result = 0;
        int start = 0;
        
        while(start + 1 < prices.length){
            if (prices[start] >= prices[start + 1]) {
                start ++;
                if (start + 1 >= prices.length) break;
            }
            else{
                int end = start + 1;
                while (end < prices.length && prices[end] >= prices[end - 1]) end ++;
                result += prices[end - 1] - prices[start];
                start = end;
            }
        }
        
        return result;
    }
}
