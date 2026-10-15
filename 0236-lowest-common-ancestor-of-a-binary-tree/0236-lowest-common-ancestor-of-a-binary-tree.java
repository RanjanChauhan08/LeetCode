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
    public TreeNode helper(TreeNode root,int p,int q){
        if(root==null)return null;
        if(root.val==p || root.val==q)return root;
        TreeNode l=helper(root.left,p,q);
        TreeNode r=helper(root.right,p,q);
        if(l!=null && r!=null)return root;
        else if(l==null && r==null)return null;
        else if(r==null)return l;
        return r;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p.val,q.val);
    }
}