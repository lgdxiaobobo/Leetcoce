import java.util.HashSet;
import java.util.HashMap;

public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 1) return true;
        else if (stones.length == 2) return stones[1] == 1;
        else{
            HashMap<Integer, HashSet<Integer>> isOK = new HashMap<Integer, HashSet<Integer>>();
            int N = stones.length;
            int[] maxStep = new int[N];
            
            HashSet<Integer> tmp = new HashSet<Integer>();
            tmp.add(1);
            isOK.put(0, tmp);
            maxStep[0] = 1;
            
            for (int n = 1; n < N; n ++){
                HashSet<Integer> step = new HashSet<Integer>();
                maxStep[n] = 0;
                for (int m = n - 1; m >= 0; m --){
                    if (isOK.containsKey(m)){
                       int k = stones[n] - stones[m];
                       if (k > maxStep[m] + 1){
                           break;
                       }
                       HashSet<Integer> oldStep = isOK.get(m);
                       if (oldStep.contains(k) || (m > 0 && (oldStep.contains(k-1) || oldStep.contains(k+1)))){
                          step.add(k);
                          maxStep[n] = (maxStep[n] < k)? k:maxStep[n];
                       }
                    }
                }
                if (step.size() > 0) isOK.put(n, step);
            }
            
            if (!isOK.containsKey(N-1)) return false;
            else return true;
        }        
    }
}