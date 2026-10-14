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
    public TreeNode helper(int[]preorder,int low,int high){
        if(low>high)return null;
        if(low==high)return new TreeNode(preorder[low]);
        TreeNode head=new TreeNode(preorder[low]);
        int mid=getMid(preorder,preorder[low],low,high);
        head.left=helper(preorder,low+1,mid-1);
        if(mid==-1){
            head.right=null;
            head.left=helper(preorder,low+1,high);
        }
        else{
            head.right=helper(preorder,mid,high);
            head.left=helper(preorder,low+1,mid-1);
        }
        return head;
    }
    public int getMid(int[]preorder,int val,int low,int high){
        int a=low+1;
        while(a<=high){
            if(preorder[a]>val)return a;
            a++;
        }
        return -1;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
}