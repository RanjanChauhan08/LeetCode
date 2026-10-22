class Solution {
    public boolean dfs(char[]visited,int x,char parent,ArrayList<ArrayList<Integer>>adj){
        if(parent=='\u0000'){
            visited[x]='b';
        }
        else if(parent=='w')visited[x]='b';
        else visited[x]='w';
        for(int j=0;j<adj.get(x).size();j++){
            if(visited[adj.get(x).get(j)]=='\u0000'){
                if(!dfs(visited,adj.get(x).get(j),visited[x],adj))return false;
            }
            else if(visited[adj.get(x).get(j)]==visited[x])return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++)adj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
                adj.get(graph[i][j]).add(i);
            }
        }
        char[]visited=new char[graph.length];
        for(int i=0;i<visited.length;i++){
            if(visited[i]=='\u0000'){
                if(!dfs(visited,i,'\u0000',adj))return false;
            }
        }
        return true;
    }
}