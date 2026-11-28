class pair{
    int node;
    int time;
    pair(int node,int time){
        this.node=node;
        this.time=time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)adj.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int a=times[i][0];
            int b=times[i][1];
            int c=times[i][2];
            pair np=new pair(b,c);
            ArrayList<pair>p=adj.get(a);
            p.add(np);
        }
        int[]visited=new int[n+1];
        Queue<pair>queue=new PriorityQueue<>((a,b)->{
            if(a.time!=b.time)return Integer.compare(a.time,b.time);
            return Integer.compare(a.node,b.node); 
        });
        queue.add(new pair(k,0));
        int ans=0;
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int node=p.node;
            int time=p.time;
            if(visited[node] == 1) continue;
            visited[node]=1;
            ans=time;
            for(pair newPair:adj.get(node)){
                int newTime=newPair.time;
                int newNode=newPair.node;
                if(visited[newNode]==0){
                    queue.add(new pair(newNode,newTime+time));
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(visited[i]==0)return -1;
        }
        return ans;
    }
}