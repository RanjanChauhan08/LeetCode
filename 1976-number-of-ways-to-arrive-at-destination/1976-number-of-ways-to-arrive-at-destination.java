class pair {
    int node;
    long dist;

    pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        TreeSet<pair> set = new TreeSet<>((a,b) -> {
            if(a.dist != b.dist)
                return Long.compare(a.dist,b.dist);
            return Integer.compare(a.node,b.node);
        });
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int d=roads[i][2];
            adj.get(u).add(new pair(v,d));
            adj.get(v).add(new pair(u,d));
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[]ways=new int[n];
        ways[0]=1;
        dis[0]=0;
        set.add(new pair(0,0));
        while(!set.isEmpty()){
            pair p=set.pollFirst();
            for(int i=0;i<adj.get(p.node).size();i++){
                int newNode=adj.get(p.node).get(i).node;
                long newDist = adj.get(p.node).get(i).dist + p.dist;
                if(dis[newNode]<newDist)continue;
                if(dis[newNode]>newDist){
                    ways[newNode]=ways[p.node];
                }
                else if(dis[newNode]==newDist){
                    ways[newNode] = (ways[newNode] + ways[p.node]) % 1000000007;
                }
                if(dis[newNode]>newDist){
                    if(dis[newNode]!=10000000){
                        pair rp=new pair(newNode,dis[newNode]);
                        set.remove(rp);
                    }
                    dis[newNode]=newDist;
                    pair newp=new pair(newNode,dis[newNode]);
                    set.add(newp);
                }
            }
        }
        return ways[n-1];
    }
}