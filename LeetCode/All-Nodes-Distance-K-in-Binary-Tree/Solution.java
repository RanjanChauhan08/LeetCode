1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public void helper(TreeNode node,Map<TreeNode,TreeNode>child_parent,int dist,List<Integer>ans,Set<TreeNode>set){
12        if(node==null || dist<0 || set.contains(node))return;
13        if(dist==0 && !set.contains(node)){
14            ans.add(node.val);
15            set.add(node);
16            return;
17        }
18        set.add(node);
19        helper(node.left,child_parent,dist-1,ans,set);
20        helper(node.right,child_parent,dist-1,ans,set);
21        helper(child_parent.get(node),child_parent,dist-1,ans,set);
22    }
23    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
24        Map<TreeNode,TreeNode>child_parent=new HashMap<>();
25        Queue<TreeNode>queue=new LinkedList<>();
26        queue.add(root);
27        while(!queue.isEmpty()){
28            int size=queue.size();
29            for(int i=0;i<size;i++){
30                TreeNode n=queue.poll();
31                if(n.left!=null){
32                    queue.add(n.left);
33                    child_parent.put(n.left,n);
34                }
35                if(n.right!=null){
36                    queue.add(n.right);
37                    child_parent.put(n.right,n);
38                }
39            }
40        }
41        List<Integer>ans=new ArrayList<>();
42        Set<TreeNode>set=new HashSet<>();
43        helper(target,child_parent,k,ans,set);
44        return ans;
45    }
46}