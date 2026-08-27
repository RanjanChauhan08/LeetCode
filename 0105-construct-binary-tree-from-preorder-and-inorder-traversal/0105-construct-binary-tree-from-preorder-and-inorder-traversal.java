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
    public TreeNode helper(int[]preorder,int[]inorder,int preS,int preE,int inS,int inE){
        if(preS>preE)return null;
        TreeNode root=new TreeNode(preorder[preS]);
        if(preS==preE)return root;
        int target=preorder[preS];
        int ind=-1;
        for(int i=inS;i<=inE;i++){
            if(inorder[i]==target){
                ind=i;
            }
        }
        int l=ind-(inS);
        TreeNode left=helper(preorder,inorder,preS+1,preS+l,inS,inS+l-1);
        TreeNode right=helper(preorder,inorder,preS+l+1,preE,inS+l+1,inE);
        root.left=left;
        root.right=right;
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        int len=preorder.length-1;
        return helper(preorder,inorder,0,len,0,len);
    }
}