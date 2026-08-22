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
16import java.util.*;
17class Solution {
18    public void helper(List<Integer>ans,TreeNode node,Map<Integer,Integer>mpp,int index){
19        if(node==null)return;
20        if(mpp.get(index)==null){
21            mpp.put(index,node.val);
22            ans.add(node.val);
23        }
24        if(node.right!=null)helper(ans,node.right,mpp,index+1);
25        helper(ans,node.left,mpp,index+1);
26    }
27    public List<Integer> rightSideView(TreeNode root) {
28        List<Integer>ans=new ArrayList<>();
29        Map<Integer,Integer>mpp=new HashMap<>();
30        helper(ans,root,mpp,0);
31        return ans;
32    }
33}