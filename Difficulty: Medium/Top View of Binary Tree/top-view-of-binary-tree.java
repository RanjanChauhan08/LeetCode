/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class pair{
    Node node;
    int x;
    pair(Node node,int x){
        this.node=node;
        this.x=x;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
        Map<Integer,Integer>mpp=new TreeMap<>();
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(root,0));
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                int x=p.x;
                Node node=p.node;
                if(mpp.get(x)==null){
                    mpp.put(x,node.data);
                }
                if(node.left!=null){
                    queue.add(new pair(node.left,x-1));
                }
                if(node.right!=null){
                    queue.add(new pair(node.right,x+1));
                }
            }
        }
        for(Integer val:mpp.values()){
            ans.add(val);
        }
        return ans;
    }
}