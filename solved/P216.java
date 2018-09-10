import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> result;
    public void find(List<Integer> tmp, int left, int k, int n){
        if (k == 0){
            if (n == 0){
                List<Integer> temp = new ArrayList<Integer>();
                for (int i = 0; i < tmp.size(); i ++){
                    temp.add(tmp.get(i));
                }
                result.add(temp);
            }
        }
        else{
            for (int i = left + 1; i * (k - 1) < n && i <= 9; i ++){
                tmp.add(i);
                find(tmp, i, k - 1, n - i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<List<Integer>>();
        for (int i = 1; i * k < n && i <= 9; i ++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(i);
            find( tmp, i, k-1, n-i);
        }
        return result;
    }
}