public class Solution {

    public class Tree{
        Tree left = null;
        Tree right = null;
    }

    public void construct(Tree tree, int x){
        for (int i = 31; i >= 0; --i){
            boolean flag = (x & (1 << i)) == 0;
            
            if (flag){
                if (tree.left == null) tree.left = new Tree();
                tree = tree.left;
            }
            else{
                x = x - (1 << i);
                if (tree.right == null) tree.right = new Tree();
                tree = tree.right;
            }
        }
    }

    public int findResult(Tree tree, int x){
        int result = 0;
        for (int i = 31; i >= 0; --i){
            boolean flag = (x & (1 << i)) != 0;
            
            if (flag){
                if (tree.left != null) {
                    result |= (1 << i);
                    tree = tree.left;
                }
                else tree = tree.right;
            }
            else{
                if (tree.right != null) {
                    result |= (1 << i);
                    tree = tree.right;
                }
                else tree = tree.left; 
            }
        }
        return result;
    }

    public int findMaximumXOR(int[] nums) {

        if (nums.length < 2) return 0;

        Tree trie_tree = new Tree();

        for (int x: nums){
            construct(trie_tree, x);
        }

        int maxNum = 0;
        for (int x: nums){
            int tmp = findResult(trie_tree, x);
            if (maxNum < tmp){
                maxNum = tmp;
            }
        }

        return maxNum;
    }   
    
}