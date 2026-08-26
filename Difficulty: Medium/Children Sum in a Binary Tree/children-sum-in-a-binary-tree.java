/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean helper(Node node){
        if(node==null)return true;
        if(node.left==null && node.right==null)return true;
        int sum=0;
        if(node.left!=null)sum=sum+node.left.data;
        if(node.right!=null)sum=sum+node.right.data;
        return sum==node.data && helper(node.left) && helper(node.right);
    }
    public boolean isSumProperty(Node root) {
        return helper(root);
    }
}