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
17    public TreeNode helper(int[]preorder,int[]inorder,int preS,int preE,int inS,int inE){
18        if(preS>preE)return null;
19        TreeNode root=new TreeNode(preorder[preS]);
20        if(preS==preE)return root;
21        int target=preorder[preS];
22        int ind=-1;
23        for(int i=inS;i<=inE;i++){
24            if(inorder[i]==target){
25                ind=i;
26            }
27        }
28        int l=ind-(inS);
29        TreeNode left=helper(preorder,inorder,preS+1,preS+l,inS,inS+l-1);
30        TreeNode right=helper(preorder,inorder,preS+l+1,preE,inS+l+1,inE);
31        root.left=left;
32        root.right=right;
33        return root;
34    }
35    public TreeNode buildTree(int[] preorder, int[] inorder) {
36        if(preorder.length==0)return null;
37        int len=preorder.length-1;
38        return helper(preorder,inorder,0,len,0,len);
39    }
40}