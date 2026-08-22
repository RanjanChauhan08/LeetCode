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
    int index;
    int row;
    TreeNode node;

    pair(int index, int row, TreeNode node) {
        this.index = index;
        this.row = row;
        this.node = node;
    }
}
class Position {
    int index;
    int row;

    Position(int index, int row) {
        this.index = index;
        this.row = row;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(0,0,root));
        Map<Position, ArrayList<Integer>> mpp = new TreeMap<>(
            (a, b) -> {
                if (a.index != b.index)
                    return Integer.compare(a.index, b.index);
                return Integer.compare(a.row, b.row);
            }
        );
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                TreeNode node=p.node;
                int index=p.index;
                int row=p.row;
                Position position=new Position(index,row);
                if(mpp.get(position)==null){
                    mpp.put(position,new ArrayList<>());
                    mpp.get(position).add(node.val);
                }
                else{
                    mpp.get(position).add(node.val);
                }
                if(node.left!=null){
                    queue.add(new pair(index-1,row+1,node.left));
                }
                if(node.right!=null){
                    queue.add(new pair(index+1,row+1,node.right));
                }
            }
        }
        int prevIndex = Integer.MIN_VALUE;

        for (Map.Entry<Position, ArrayList<Integer>> entry : mpp.entrySet()) {

            Position pos = entry.getKey();
            ArrayList<Integer> arr = entry.getValue();

            if (pos.index != prevIndex) {
                ans.add(new ArrayList<>());
                prevIndex = pos.index;
            }

            Collections.sort(arr);

            ans.get(ans.size() - 1).addAll(arr);
        }
        return ans;
    }
}