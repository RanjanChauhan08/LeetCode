/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode node,TreeNode[]f,TreeNode[]m,TreeNode[]s,TreeNode[]p){
        if(node==null)return;
        inorder(node.left,f,m,s,p);
        if(p[0]!=null && p[0].val>node.val){
            if(f[0]==null){
                f[0]=p[0];
                m[0]=node;
            }
            else{
                s[0]=node;
            }
        }
        p[0]=node;
        inorder(node.right,f,m,s,p);
    }
    public void recoverTree(TreeNode root) {
        TreeNode[]f={null};
        TreeNode[]m={null};
        TreeNode[]p={null};
        TreeNode[]s={null};
        inorder(root,f,m,s,p);
        if(f[0]!=null && s[0]!=null){
            int temp=f[0].val;
            f[0].val=s[0].val;
            s[0].val=temp;
        }
        else if(f[0]!=null && m[0]!=null){
            int temp=f[0].val;
            f[0].val=m[0].val;
            m[0].val=temp;
        }
    }
}