class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            if(manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }

        int[]time=new int[n];
        time[headID]=0;
        Queue<Integer>queue=new LinkedList<>();
        queue.add(headID);
        int ans=0;
        while(!queue.isEmpty()){
                int p=queue.poll();
                 for(int emp : adj.get(p)) {

                    time[emp] = time[p] + informTime[p];

                    ans = Math.max(ans, time[emp]);

                    queue.add(emp);
                }
            }
        return ans;
    }
}