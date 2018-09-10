public class Solution {
    public int[] find_max_sub(int[] nums, int max_k, int[][] ref_dict){
        if (max_k == 0) return null;
        
        int[] result = new int[max_k];
        
        int len = nums.length;
        
        int start = 0;
        int k = 0;
        while (k < max_k){
            int left = start;
            int right= len + k - max_k;
            
            int distance = right - left + 1;
            int index = left;
            int p = left;
            int q = 0;
            while (distance > 0){
                if (distance % 2 == 1){
                    if (nums[index] < nums[ref_dict[p][q]]){
                        index = ref_dict[p][q];
                    }
                    p = p + (1 << q);
                }
                distance = distance / 2;
                q += 1;
            }
            start = index + 1;
            result[k++] = nums[index];
        }
        
        return result;
    }
    
    public int[] max_insert(int[] val1, int[] val2){
        int l1 = (val1 == null)? 0:val1.length;
        int l2 = (val2 == null)? 0:val2.length;
        
        if (l1 == 0) return val2;
        if (l2 == 0) return val1;
        
        int len= l1 + l2;
        
        int[] result = new int[l1+l2];
        
        int i, j, l;
        for (i = 0, j = 0, l = 0; i < l1 && j < l2;){
            if (val1[i] < val2[j]){
                result[l++] = val2[j++];
            }
            else if (val1[i] > val2[j]){
                result[l++] = val1[i++];
            }
            else{
                if (insert_mode(val1, val2, i, j)){
                    result[l++] = val1[i++];
                }
                else{
                    result[l++] = val2[j++];
                }
            }
        }
        
        if (i >= l1){
            for (;l < len;){
                result[l++] = val2[j++];
            }
        }
        else if (j >= l2){
            for(;l < len;){
                result[l++] = val1[i++];
            }
        }
        
        return result;
    }
    
    public boolean insert_mode(int[] val1, int[] val2, int i, int j) {
        boolean flag = false;
        int l1 = val1.length;
        int l2 = val2.length;
        int t1, t2;
        for (t1 = i, t2 = j; t1 < l1 && t2 < l2;){
            if (val1[t1] == val2[t2]){
                t1 ++;
                t2 ++;
            }
            else if (val1[t1] > val2[t2]){
                return true;
            }
            else{
                return false;
            }
        }
        
        if (t1 >= l1){
            for (; t2 < l2; t2 ++){
                if (val2[t2] > val2[t2-1]){
                    return false;
                }
                else if (val2[t2] < val2[t2-1]){
                    return true;
                }
            }
        }
        
        else if (t2 >= l2){
            for (; t1 < l1; t1 ++){
                if (val1[t1] > val1[t1-1]){
                    return true;
                }
                else if (val1[t1] < val1[t1-1]){
                    return false;
                }
            }
        }
        
        return flag;
    }

    public boolean is_large(int[] tmp1, int[] tmp2){
        boolean flag = false;
        for (int i = 0; i < tmp1.length; i ++){
            if (tmp2[i] < tmp1[i]){
                flag = true;
                break;
            }
            else if (tmp2[i] > tmp1[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public int[][] construct(int[] nums){
        int max_n = nums.length;
        
        int n = max_n;
        int max_k = 0;
        
        while(n > 0){
            n = n / 2;
            max_k ++;
        }
        
        int[][] result = new int[max_n][max_k];

        for (int k = 0; k < max_k; k ++){
            for (int i = 0; i + (1 << k) <= max_n; i ++){
                if (k == 0) result[i][k] = i;
                else{
                    int s = i;
                    int t = i + (1 << (k - 1));
                    int val1 = nums[result[s][k-1]];
                    int val2 = nums[result[t][k-1]];
                    result[i][k] = (val1 >= val2) ? result[i][k-1]: result[t][k-1];
                }
            }
        }
        return result;
    }
    
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        int[][] nums1_tree = construct(nums1);
        int[][] nums2_tree = construct(nums2);
        
        int[] result = new int[k];
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        for (int k1 = 0; k1 <= k; k1 ++){
            if (k1 > l1 || k - k1 > l2) continue; 
            int[] val1 = find_max_sub(nums1, k1, nums1_tree);
            int[] val2 = find_max_sub(nums2, k-k1, nums2_tree);
            
            int[] temp = max_insert(val1, val2);
            
            if (is_large(temp, result)){
                for (int i = 0; i < k; i ++){
                    result[i] = temp[i];
                }
            }
        }
        
        return result;
    }
}