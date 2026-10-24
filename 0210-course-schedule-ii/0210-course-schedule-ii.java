class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]ans=new int[numCourses];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int[]inorder=new int[numCourses];
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            inorder[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0)queue.add(i);
        }
        int n=0;
        int x=0;
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                int a=queue.poll();
                n++;
                ans[x++]=a;
                for(int j=0;j<adj.get(a).size();j++){
                    int b=adj.get(a).get(j);
                    inorder[b]--;
                    if(inorder[b]==0){
                        queue.add(b);
                    }
                }
            }
        }
        return n==numCourses?ans:new int[0];
    }
}