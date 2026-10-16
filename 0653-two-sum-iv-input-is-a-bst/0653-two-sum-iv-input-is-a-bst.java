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
    Stack<TreeNode>l=new Stack<>();
    Stack<TreeNode>r=new Stack<>();

    public boolean hasNext1(){
        return !l.isEmpty();
    }

    public boolean hasNextr(){
        return !r.isEmpty();
    }

    public int next(){
        TreeNode node=l.pop();
        TreeNode temp=node.right;
        while(temp!=null){
            l.push(temp);
            temp=temp.left;
        }
        return node.val;
    }

    public int before(){
        TreeNode node=r.pop();
        TreeNode temp=node.left;
        while(temp!=null){
            r.push(temp);
            temp=temp.right;
        }
        return node.val;
    }

    public boolean findTarget(TreeNode root, int k) {

        if(root==null)return false;

        if(root.left==null && root.right==null){
            return false;
        }

        TreeNode temp=root;
        while(temp!=null){
            l.push(temp);
            temp=temp.left;
        }
        temp=root;
        while(temp!=null){
            r.push(temp);
            temp=temp.right;
        }
        while(hasNextr() && hasNext1()){
            int value=r.peek().val+l.peek().val;
            if(r.peek().val<=l.peek().val)return false;
            if(value==k)return true;
            else if(value<k){
                next();
            }
            else{
                before();
            }
        }
        return false;
    }
}