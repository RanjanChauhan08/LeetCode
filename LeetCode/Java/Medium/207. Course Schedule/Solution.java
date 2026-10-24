class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[]indegree=new int[numCourses];
       ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
       for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
       for(int i=0;i<prerequisites.length;i++){
        int u=prerequisites[i][0];
        int v=prerequisites[i][1];
        adj.get(v).add(u);
        indegree[u]++;
       } 
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int x=queue.poll();
                for(Integer y:adj.get(x)){
                    indegree[y]--;
                    if(indegree[y]==0){
                        queue.add(y);
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]!=0)return false;
        } 
        return true;
    }
}