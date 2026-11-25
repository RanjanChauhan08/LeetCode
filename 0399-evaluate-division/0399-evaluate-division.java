
import java.util.*;

class pair {
    String st;
    double dist;

    pair(String st, double dist) {
        this.st = st;
        this.dist = dist;
    }
}

class Solution {

    public double dfs(String src, String dest,
                      HashMap<String, ArrayList<pair>> adj,
                      HashSet<String> visited) {

        if (src.equals(dest)) return 1.0;

        visited.add(src);

        for (pair p : adj.get(src)) {

            if (!visited.contains(p.st)) {

                double ans = dfs(p.st, dest, adj, visited);

                if (ans != -1.0) {
                    return p.dist * ans;
                }
            }
        }

        return -1.0;
    }

    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries) {

        HashMap<String, ArrayList<pair>> adj = new HashMap<>();

        // Build graph
        for (int i = 0; i < values.length; i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());

            adj.get(a).add(new pair(b, values[i]));
            adj.get(b).add(new pair(a, 1.0 / values[i]));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if (!adj.containsKey(a) || !adj.containsKey(b)) {
                ans[i] = -1.0;
            }
            else {
                HashSet<String> visited = new HashSet<>();

                ans[i] = dfs(a, b, adj, visited);
            }
        }

        return ans;
    }
}
