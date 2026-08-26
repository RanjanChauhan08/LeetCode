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
17    public int getleftheight(TreeNode node){
18        int n=0;
19        while(node!=null){
20            node=node.left;
21            n++;
22        }
23        return n;
24    }
25    public int getrightheight(TreeNode node){
26        int n=0;
27        while(node!=null){
28            node=node.right;
29            n++;
30        }
31        return n;
32    }
33    public int countNodes(TreeNode root) {
34        if(root==null)return 0;
35        int r=getrightheight(root);
36        int l=getleftheight(root);
37        if(r == l){
38            return (int)(Math.pow(2,r)-1);
39        }
40        return 1+countNodes(root.left)+countNodes(root.right);
41    }
42}