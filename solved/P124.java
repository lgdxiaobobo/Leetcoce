public class Solution {
     int result;

     public int maxKidSum(TreeNode root) {
         int maxSum = root.val;
         
         int current = maxSum;
         int pathSum = maxSum;
         
         if (root.left != null){
             int tmp = maxKidSum(root.left);
             maxSum  = max(maxSum, tmp + current);
             pathSum+= max(0, tmp);
         }
         if (root.right != null){
             int tmp = maxKidSum(root.right);
             maxSum  = max(maxSum, tmp + current);
             pathSum+= max(0, tmp);
         }
         
         if (pathSum > result) result = pathSum;
         
         return maxSum;
     }
    
     public int max(int a, int b){
         return (a > b)? a: b;
     }

     public int maxPathSum(TreeNode root) {
         result = root.val;
         int tmp = maxKidSum(root);
         return result;
     }
}
