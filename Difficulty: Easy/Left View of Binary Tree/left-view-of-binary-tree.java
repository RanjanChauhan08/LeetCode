/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}*/

class Solution {
    public void helper(Node node,ArrayList<Integer>ans,int index,Map<Integer,Integer>mpp){
        if(node==null)return;
        if(mpp.get(index)==null){
            mpp.put(index,node.data);
            ans.add(node.data);
        }
        if(node.left!=null){
            helper(node.left,ans,index+1,mpp);
        }
        helper(node.right,ans,index+1,mpp);
    }
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
        Map<Integer,Integer>mpp=new HashMap<>();
        helper(root,ans,0,mpp);
        return ans;
    }
}