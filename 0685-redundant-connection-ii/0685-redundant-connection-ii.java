
import java.util.*;

class Solution {

    int[] parent;

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        // Tracks incoming parent of each node
        int[] par = new int[n + 1];

        int[] cand1 = new int[2];
        int[] cand2 = new int[2];

        // Step 1: Detect node with two parents
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (par[v] == 0) {
                par[v] = u;
            }
            else {
                cand1 = new int[]{par[v], v};
                cand2 = new int[]{u, v};

                break;
            }
        }

        // Step 2: Initialize DSU
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // Step 3: Detect cycle, skipping cand2
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Skip the second parent edge
            if (u == cand2[0] && v == cand2[1]) {
                continue;
            }

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {

                // Cycle found
                if (cand1[0] == 0) {
                    return edge;
                }

                return cand1;
            }

            parent[pu] = pv;
        }

        // No cycle after skipping second parent edge
        return cand2[0] == 0 ? new int[0] : cand2;
    }
}
