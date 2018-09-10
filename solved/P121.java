public class Solution {
    
    public int max(int a, int b){
        return (a > b)? a : b;
    }
    
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int len = prices.length;
        
        int[] maxIndex = new int[len];
        
        maxIndex[len-1] = prices[len-1];
        for (int i = len - 2; i >= 0; i --){
            maxIndex[i] = max(prices[i], maxIndex[i+1]);
        }
        
        int result = 0;
        for (int i = 0; i + 1< len; i ++){
            if (result < maxIndex[i + 1] - prices[i]){
                result = maxIndex[i + 1] - prices[i];
            }
        }        
        return result;
    }
}