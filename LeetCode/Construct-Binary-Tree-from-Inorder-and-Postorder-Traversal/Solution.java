1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode helper(int[]inorder,int[]postorder,int inS,int inE,int postS,int postE){
18        if(inS>inE)return null;
19        TreeNode root=new TreeNode(postorder[postE]);
20        if(inS==inE)return root;
21        int target=postorder[postE];
22        int ind=-1;
23        for(int i=inS;i<=inE;i++){
24            if(inorder[i]==target){
25                ind=i;
26                break;
27            }
28        }
29        int l=ind-(inS);
30        root.right=helper(inorder,postorder,inS+l+1,inE,postS+l,postE-1);
31        root.left=helper(inorder,postorder,inS,inS+l-1,postS,postS+l-1);
32        return root;
33    }
34    public TreeNode buildTree(int[] inorder, int[] postorder) {
35        if(inorder.length==0)return null;
36        int len=inorder.length-1;
37        return helper(inorder,postorder,0,len,0,len);
38    }
39}