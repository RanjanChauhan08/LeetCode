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
    public void helper(TreeNode node,Set<String>set,String str){
        if(node==null)return;
        if(node.left==null && node.right==null){
            str=str+node.val;
            set.add(str);
            return;
        }
        str=str+node.val+"->";
        helper(node.left,set,str);
        if(str.length()>=4 && set.contains(str)){
            str=str.substring(0,str.length()-3);
        }
        helper(node.right,set,str);
        if(str.length()>=4 && set.contains(str)){
            str=str.substring(0,str.length()-3);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new LinkedList<>();
        if(root==null)return ans;
        Set<String>set=new TreeSet<>();
        String str="";
        helper(root,set,str);

        for(String st:set){
            ans.add(st);
        }
        return ans;
    }
}