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
class pair{
    int index=0;
    TreeNode node;
    pair(TreeNode node,int index){
        this.index=index;
        this.node=node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max=0;
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(root,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            int f=0;
            int e=0;
            for(int i=0;i<size;i++){
                pair p=queue.poll();
                int index=p.index;
                TreeNode node=p.node;
                if(i==0){
                    f=index;
                }
                if(i==size-1){
                    e=index;
                }
                if(node.left!=null){
                    queue.add(new pair(node.left,2*index+1));
                }
                if(node.right!=null){
                    queue.add(new pair(node.right,2*index+2));
                }
            }
            max=Math.max(max,(e-f)+1);
        }
        return max;
    }
}