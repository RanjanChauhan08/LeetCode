/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    void helper(Node node,int tar,int[]ans){
        if(node==null || ans[0]==tar)return;
        if(node.data==tar){
            ans[0]=node.data;
            return;
        }
        if(node.data>tar){
            ans[0]=node.data;
            helper(node.left,tar,ans);
        }
        else{
            helper(node.right,tar,ans);
        }
    }
    int findCeil(Node root, int x) {
        int[]ans={-1};
        helper(root,x,ans);
        return ans[0];
    }
}