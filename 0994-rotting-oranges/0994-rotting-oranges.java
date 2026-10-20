class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][]visited=new int[grid.length][grid[0].length];
        Queue<pair>queue=new LinkedList<>();
        boolean check=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new pair(i,j));
                    visited[i][j]=1;
                }
                if(grid[i][j]==1)check=true;
            }
        }
        int time=-1;
        if(queue.isEmpty() && check)return -1;
        if(!check)return 0;
        int[]x={0,1,0,-1};
        int[]y={-1,0,1,0};
        while(!queue.isEmpty()){
            int len=queue.size();
            time++;
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                for(int j=0;j<4;j++){
                    int n=x[j]+p.r;
                    int m=y[j]+p.c;
                    if(n>=0 && n<grid.length && m>=0 && m<grid[0].length && grid[n][m]==1 && visited[n][m]==0){
                        visited[n][m]=1;
                        grid[n][m]=2;
                        queue.add(new pair(n,m));
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)return -1;
            }
        }
        return time;
    }
}