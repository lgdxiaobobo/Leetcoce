/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {

    def change(curr: TreeNode): (TreeNode, TreeNode) = {
        // println(curr.value)
        if (curr.left == null && curr.right == null) (curr, curr)
        else if (curr.left == null){
            val (right0, right1) = change(curr.right)
            curr.right = right0
            (curr, right1)
        }
        else if (curr.right == null){
            val (left0, left1) = change(curr.left)
            left1.right = curr
            curr.left = null
            (left0, curr)
        }
        else{
            val (left0, left1) = change(curr.left)
            val (right0, right1) = change(curr.right)
            left1.right = curr
            curr.left = null
            curr.right = right0
            (left0, right1)
        }
    }

    def increasingBST(root: TreeNode): TreeNode = {
        change(root)._1
    }
}