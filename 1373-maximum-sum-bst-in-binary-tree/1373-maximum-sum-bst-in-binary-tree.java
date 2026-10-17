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
class Cust{
    int smallest;
    int greatest;
    int sum;
    Cust(int smallest,int greatest,int sum){
        this.smallest=smallest;
        this.greatest=greatest;
        this.sum=sum;
    }
}
class Solution {
    public Cust postOrder(TreeNode node,int[]max){
        if(node==null)return new Cust(1000000000,-100000000,0);
        Cust l=postOrder(node.left,max);
        Cust r=postOrder(node.right,max);
        if(r.smallest>node.val && l.greatest<node.val){
            max[0]=Math.max(max[0],node.val+l.sum+r.sum);
            return new Cust(
                Math.min(l.smallest, node.val),
                Math.max(r.greatest, node.val),
                node.val + l.sum + r.sum
            );        
        }
        return new Cust(-1000000000,1000000000,0);
    }
    public int maxSumBST(TreeNode root) {
        int[]max={0};
        postOrder(root,max);
        return max[0];
    }
}