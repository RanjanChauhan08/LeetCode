/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class pair{
    int index;
    Node node;
    pair(int index,Node node){
        this.index=index;
        this.node=node;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(0,root));
        Map<Integer,Integer>mpp=new TreeMap<>();
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                int index=p.index;
                Node node=p.node;
                mpp.put(index,node.data);
                if(node.left!=null){
                    queue.add(new pair(index-1,node.left));
                }
                if(node.right!=null){
                    queue.add(new pair(index+1,node.right));
                }
            }
        }
        for(Integer i:mpp.values()){
            ans.add(i);
        }
        return ans;
    }
}