public class Solution{
    
    public int min(int a, int b){
        return (a < b)? a:b;
    }
    
    public int max(int a, int b){
        return (a > b)? a:b;
    }
    
    public int maxProfit(int[] prices){
        int len = prices.length;
        if (len <= 1) return 0;
        int result = 0;
        
        int[] minPrices = new int[len];
        int[] maxPrices = new int[len];
        
        minPrices[0] = prices[0];
        for (int i = 1; i < len; i ++){
            minPrices[i] = min(prices[i], minPrices[i-1]);
        }
        
        maxPrices[len-1] = prices[len-1];
        for (int i = len - 2; i >= 0; i --){
            maxPrices[i] = max(prices[i], maxPrices[i+1]);
        }
        
        int[] f = new int[len];
        int[] g = new int[len];
        
        f[0] = 0;
        for (int i = 1; i < len; i ++){
            f[i] = max(0, prices[i] - minPrices[i-1]);
            f[i] = max(f[i], f[i-1]);
        }
        
        g[len-1] = 0;
        for (int i = len - 2; i >= 0; i --){
            g[i] = max(0, maxPrices[i+1] - prices[i]);
            g[i] = max(g[i], g[i+1]);
        }
        
        for (int i = 0; i < len - 1; i ++){
            result = max(result, f[i] + g[i+1]);
        }
        result = max(result, g[0]);
        result = max(result, f[len-1]);     
        return result;
    }
}