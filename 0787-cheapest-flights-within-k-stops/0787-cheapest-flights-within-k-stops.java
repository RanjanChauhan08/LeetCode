class pair{
    int node;
    int dis;
    int k;
    pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
    pair(int node,int dis,int k){
        this.node=node;
        this.dis=dis;
        this.k=k;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        int[]dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=10000000;
        }
        dist[src]=0;
        Queue<pair>qp=new LinkedList<>();
        qp.add(new pair(src,0,0));
        while(!qp.isEmpty()){
            pair p=qp.poll();
            if(p.node==dst && p.k<=k+1){
                dist[dst]=Math.min(dist[dst],p.dis);
            }
            else{
                for(int i=0;i<adj.get(p.node).size();i++){
                    int adjNode=adj.get(p.node).get(i).node;
                    if(dist[adjNode]>p.dis+adj.get(p.node).get(i).dis){
                        if((p.k)+1>k+1) continue;
                        dist[adjNode]=p.dis+adj.get(p.node).get(i).dis;
                        qp.add(new pair(adjNode,p.dis+adj.get(p.node).get(i).dis,(p.k)+1));
                    }
                }
            }
        }
        if(dist[dst]==10000000)return -1;
        return dist[dst];
    }
}