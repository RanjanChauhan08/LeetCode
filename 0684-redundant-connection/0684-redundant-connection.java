
import java.util.*;

class DisjointSet {
    int[] parent;
    int[] rank;

    // Initialize DSU
    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find Ultimate Parent with Path Compression
    int findUPar(int node) {

        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    // Union by Rank
    void unionByRank(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // Already in the same component
        if (ulp_u == ulp_v) {
            return;
        }

        // Attach smaller rank under larger rank
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }

        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }

        // If ranks are equal
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Check if two nodes belong to same component
    boolean isConnected(int u, int v) {
        return findUPar(u) == findUPar(v);
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=0;
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            n=Math.max(n,a);
            n=Math.max(n,b);
        }
        DisjointSet dj=new DisjointSet(n+1);
        int[]ans=new int[2];
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            if(!dj.isConnected(a,b)){
                dj.unionByRank(a,b);
            }
            else{
                dj.unionByRank(a,b);
                ans[0]=a;
                ans[1]=b;
            }
        }
        return ans;
    }
}