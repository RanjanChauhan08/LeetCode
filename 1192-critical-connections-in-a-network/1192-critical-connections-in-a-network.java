class Solution {
    public int timer=1;
    public void dfs(ArrayList<ArrayList<Integer>>adj,int parent,int node,int[]visited,int[]low,int []finish,List<List<Integer>>bridge){
        visited[node]=1;
        low[node]=timer;
        finish[node]=timer;
        timer++;
        for(int i=0;i<adj.get(node).size();i++){
            int newNode=adj.get(node).get(i);
            if(newNode==parent)continue;
            if(visited[newNode]==0){
                dfs(adj,node,newNode,visited,low,finish,bridge);
                low[node]=Math.min(low[node],low[newNode]);
                if(low[newNode]>finish[node]){
                    List<Integer>miniAns=new ArrayList<>();
                    miniAns.add(node);
                    miniAns.add(newNode);
                    bridge.add(miniAns);
                }
            }
            else if(low[newNode]<low[node]){
                low[node]=low[newNode];
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer>ls:connections){
            adj.get(ls.get(0)).add(ls.get(1));
            adj.get(ls.get(1)).add(ls.get(0));
        }
        int[]low=new int[n];
        int[]visited=new int[n];
        int[]finish=new int[n];
        List<List<Integer>>bridge=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(adj,-1,i,visited,low,finish,bridge);
            }
        }
        return bridge;
    }
}