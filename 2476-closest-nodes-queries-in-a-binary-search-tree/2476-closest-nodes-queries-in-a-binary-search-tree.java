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
    public void inorder(TreeNode node,ArrayList<Integer>ans){
        if(node==null)return;
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>arr=new ArrayList<>();
        inorder(root,arr);
        for(int i=0;i<queries.size();i++){
            int l = 0;
            int r = arr.size() - 1;
            int low=-1;
            int high=-1;
            int tar=queries.get(i);
            List<Integer>miniAns=new ArrayList<>();
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (arr.get(mid) == tar) {
                    low = arr.get(mid);
                    high = arr.get(mid);
                    break;
                }
                else if (arr.get(mid) < tar) {
                    low = arr.get(mid);       // possible floor
                    l = mid + 1;
                }
                else {
                    high = arr.get(mid);      // possible ceil
                    r = mid - 1;
                }
            }
            miniAns.add(low);
            miniAns.add(high);
            ans.add(miniAns);
        }
        return ans;
    }
}