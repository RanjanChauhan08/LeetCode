import java.util.*;
class pair{
    int city;
    int count;
    pair(int city,int count){
        this.city=city;
        this.count=count;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][]dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)dist[i][j]=10000000;
            }
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int d=edges[i][2];
            dist[u][v]=d;
            dist[v][u]=d;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==10000000 || dist[k][j]==10000000){
                        continue;
                    }
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        TreeMap<pair, Integer> mpp = new TreeMap<>((a, b) -> {
            if(a.count != b.count)
                return Integer.compare(a.count, b.count);

            return Integer.compare(b.city, a.city);
        });

        for(int i = 0; i < n; i++) {

            int count = 0;

            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            mpp.put(new pair(i, count), i);
        }

        return mpp.firstKey().city;
    }
}