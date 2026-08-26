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
    public void helper(TreeNode node,int[]max,int len,Map<TreeNode,TreeNode>mpp,Set<TreeNode>set){
        if(node==null || set.contains(node))return;
        max[0]=Math.max(max[0],len);
        set.add(node);
        helper(node.left,max,len+1,mpp,set);
        helper(node.right,max,len+1,mpp,set);
        helper(mpp.get(node),max,len+1,mpp,set);
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root==null)return 0;
        Map<TreeNode,TreeNode>mpp=new HashMap<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        TreeNode target=null;
        if(root.val==start)target=root;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.val==start && target==null){
                    target=node;
                }
                if(node.left!=null){
                    queue.add(node.left);
                    mpp.put(node.left,node);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    mpp.put(node.right,node);
                }
            }
        }
        int[]max={0};
        Set<TreeNode>set=new HashSet<>();
        helper(target,max,0,mpp,set);
        return max[0];
    }
}