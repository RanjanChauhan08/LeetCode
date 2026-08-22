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
import java.util.*;
class Solution {
    public void helper(List<Integer>ans,TreeNode node,Map<Integer,Integer>mpp,int index){
        if(node==null)return;
        if(mpp.get(index)==null){
            mpp.put(index,node.val);
            ans.add(node.val);
        }
        if(node.right!=null)helper(ans,node.right,mpp,index+1);
        helper(ans,node.left,mpp,index+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Map<Integer,Integer>mpp=new HashMap<>();
        helper(ans,root,mpp,0);
        return ans;
    }
}