class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer>queue=new LinkedList<>();
        int[]inorder=new int[numCourses];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            inorder[b]++;
            adj.get(a).add(b);
        }
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0)queue.add(i);
        }
        int n=0;
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                int a=queue.poll();
                n++;
                for(int j=0;j<adj.get(a).size();j++){
                    inorder[adj.get(a).get(j)]--;
                    if(inorder[adj.get(a).get(j)]==0){
                        queue.add(adj.get(a).get(j));
                    }
                }
            }
        }
        return n==numCourses;
    }
}