/* Structure of Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}*/

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
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
                    ans.add(node.data);
                    node=node.left;
                }
                else{
                    r.right=null;
                    node=node.right;
                }
            }
        }
        return ans;
    }
}