class pair{
    int node;
    int dist;
    char color;
    pair(int node,int dist,char color){
        this.node=node;
        this.dist=dist;
        this.color=color;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[]ans=new int[n];
        for(int i=0;i<n;i++)ans[i]=-1;
        ans[0]=0;
        ArrayList<ArrayList<Integer>>adjR=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adjB=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjR.add(new ArrayList<>());
            adjB.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++){
            int u=redEdges[i][0];
            int v=redEdges[i][1];
            adjR.get(u).add(v);
        }
        for(int i=0;i<blueEdges.length;i++){
            int x=blueEdges[i][0];
            int y=blueEdges[i][1];
            adjB.get(x).add(y);
        }
        boolean[][]visited=new boolean[n][2];
        Queue<pair>queue=new PriorityQueue<>((a,b)->{
            if(a.dist!=b.dist)return Integer.compare(a.dist,b.dist);
            return Integer.compare(a.node,b.node);
        });
        queue.add(new pair(0,0,'c'));
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int node=p.node;
            int dist=p.dist;
            char color=p.color;
            if (color == 'b' || color == 'c') {

                for (int next : adjR.get(node)) {

                    if (!visited[next][0]) {
                        visited[next][0] = true;

                        if (ans[next] == -1) {
                            ans[next] = dist + 1;
                        }

                        queue.add(new pair(next, dist + 1, 'r'));
                    }
                }
            }
            if (color == 'r' || color == 'c') {

                for (int next : adjB.get(node)) {

                    if (!visited[next][1]) {
                        visited[next][1] = true;

                        if (ans[next] == -1) {
                            ans[next] = dist + 1;
                        }

                        queue.add(new pair(next, dist + 1, 'b'));
                    }
                }
            }
        }
        return ans;
    }
}