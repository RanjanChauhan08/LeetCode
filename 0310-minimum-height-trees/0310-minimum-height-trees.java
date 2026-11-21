class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1) return Arrays.asList(0);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add initial leaves
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) {
                queue.add(i);
            }
        }

        int remainingNodes = n;

        // Remove outer layers until center nodes remain
        while(remainingNodes > 2) {

            int size = queue.size();

            remainingNodes -= size;

            for(int i = 0; i < size; i++) {

                int leaf = queue.poll();

                for(int neighbor : adj.get(leaf)) {

                    degree[neighbor]--;

                    if(degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}