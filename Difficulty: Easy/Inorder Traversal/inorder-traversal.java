/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        Node node=root;
        while(node!=null){
            Node l=node.left;
            if(l==null){
                ans.add(node.data);
                node=node.right;
            }
            else{
                Node r=l;
                while(r.right!=null && r.right!=node){
                    r=r.right;
                }
                if(r.right==null){
                    r.right=node;
                    node=node.left;
                }
                else{
                    r.right=null;
                    ans.add(node.data);
                    node=node.right;
                }
            }
        }
        return ans;
    }
}