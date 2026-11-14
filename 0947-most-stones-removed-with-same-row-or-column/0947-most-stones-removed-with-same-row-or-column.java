
class Solution {

    int[] parent;
    int[] size;

    // Find with Path Compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by Size
    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        parent = new int[n];
        size = new int[n];

        // Initialize DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Connect stones having same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    union(i, j);
                }
            }
        }

        // Count connected components
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                components++;
            }
        }

        // Maximum removable stones
        return n - components;
    }
}
