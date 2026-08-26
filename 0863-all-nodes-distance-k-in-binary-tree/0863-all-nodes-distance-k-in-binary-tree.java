/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void helper(TreeNode node,Map<TreeNode,TreeNode>child_parent,int dist,List<Integer>ans,Set<TreeNode>set){
        if(node==null || dist<0 || set.contains(node))return;
        if(dist==0 && !set.contains(node)){
            ans.add(node.val);
            set.add(node);
            return;
        }
        set.add(node);
        helper(node.left,child_parent,dist-1,ans,set);
        helper(node.right,child_parent,dist-1,ans,set);
        helper(child_parent.get(node),child_parent,dist-1,ans,set);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>child_parent=new HashMap<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode n=queue.poll();
                if(n.left!=null){
                    queue.add(n.left);
                    child_parent.put(n.left,n);
                }
                if(n.right!=null){
                    queue.add(n.right);
                    child_parent.put(n.right,n);
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        Set<TreeNode>set=new HashSet<>();
        helper(target,child_parent,k,ans,set);
        return ans;
    }
}