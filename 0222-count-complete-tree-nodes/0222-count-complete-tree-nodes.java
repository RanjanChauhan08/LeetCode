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
    public int getleftheight(TreeNode node){
        int n=0;
        while(node!=null){
            node=node.left;
            n++;
        }
        return n;
    }
    public int getrightheight(TreeNode node){
        int n=0;
        while(node!=null){
            node=node.right;
            n++;
        }
        return n;
    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int r=getrightheight(root);
        int l=getleftheight(root);
        if(r == l){
            return (int)(Math.pow(2,r)-1);
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}