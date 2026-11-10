import java.util.*;

class DisjointSet {
    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int findUPar(int node) {

        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUPar(parent[node]);
    }

    boolean unionByRank(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return false;
        }

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
            return true;
        }

        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }

        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
        return true;
    }
    boolean isConnected(int u, int v) {
        return findUPar(u) == findUPar(v);
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int extra=0;
        for(int i=0;i<connections.length;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            if(!ds.unionByRank(a,b))extra++;
        }
        int noOfCom=0;
        for(int i=0;i<n;i++){
            if(ds.findUPar(i)==i)noOfCom++;
        }
        if(noOfCom-1<=extra)return noOfCom-1;
        return -1;
    }
}