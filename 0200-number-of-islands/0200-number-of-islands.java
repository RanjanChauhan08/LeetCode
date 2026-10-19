class Solution {
    public void dfs(char[][]grid,int i,int j,int[][]visited){
        visited[i][j]=1;
        int[]x={-1,0,1,0};
        int[]y={0,1,0,-1};
        for(int a=0;a<4;a++){
            int m=i+x[a];
            int n=j+y[a];
            if(m>=0 && m<grid.length && n>=0 && n<grid[0].length && visited[m][n]==0 && grid[m][n]=='1'){
                dfs(grid,m,n,visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int[][]visited=new int[grid.length][grid[0].length];
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return num;
    }
}