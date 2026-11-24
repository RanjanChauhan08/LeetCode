
import java.util.*;

class Solution {

    HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

    List<String> ans = new ArrayList<>();

    public void dfs(String src) {

        PriorityQueue<String> pq = adj.get(src);

        while (pq != null && !pq.isEmpty()) {

            String next = pq.poll();

            dfs(next);
        }

        ans.add(0, src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        adj.clear();
        ans.clear();

        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.putIfAbsent(from, new PriorityQueue<>());

            adj.get(from).offer(to);
        }

        dfs("JFK");

        return ans;
    }
}
