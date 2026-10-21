class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<pair>queue=new LinkedList<>();
        int[][]visited=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                queue.add(new pair(i,0));
                visited[i][0]=1;
            }
            if(grid[i][grid[0].length-1]==1){
                queue.add(new pair(i,grid[0].length-1));
                visited[i][grid[0].length-1]=1;
            }
        }
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]==1){
                queue.add(new pair(0,j));
                visited[0][j]=1;
            }
            if(grid[grid.length-1][j]==1){
                queue.add(new pair(grid.length-1,j));
                visited[grid.length-1][j]=1;
            }
        }
        int[]dr={0,1,0,-1};
        int[]dc={-1,0,1,0};
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                grid[p.r][p.c]=-1;
                for(int j=0;j<4;j++){
                    int nr=dr[j]+p.r;
                    int nc=dc[j]+p.c;
                    if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length || grid[nr][nc]==0 || visited[nr][nc]==1)continue;
                    if(grid[nr][nc]==1){
                        visited[nr][nc]=1;
                        grid[nr][nc]=-1;
                        queue.add(new pair(nr,nc));
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)ans++;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1)grid[i][j]=1;
            }
        }
        return ans;
    }
}