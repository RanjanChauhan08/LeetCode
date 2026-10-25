class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int[]inorder=new int[graph.length];
        for(int i=0;i<graph.length;i++)adj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
                inorder[i]++;
            }
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0){
                queue.add(i);
            }
        }
        List<Integer>ls=new ArrayList<>();
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                int a=queue.poll();
                ls.add(a);
                for(int j=0;j<adj.get(a).size();j++){
                    int b=adj.get(a).get(j);
                    inorder[b]--;
                    if(inorder[b]==0){
                        queue.add(b);
                    }
                }
            }
        }
        Collections.sort(ls);
        return ls;
    }
}