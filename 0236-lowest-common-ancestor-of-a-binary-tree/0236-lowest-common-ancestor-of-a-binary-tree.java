/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode helper(TreeNode node,int p,int q){
        if(node==null)return null;
        if(node.val==p || node.val==q){
            return node;
        }
        TreeNode l=helper(node.left,p,q);
        TreeNode r=helper(node.right,p,q);
        if(l==null || r==null){
            if(l==null)return r;
            else if(r==null)return l;
            else return null;
        }
        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p.val,q.val);
    }
}