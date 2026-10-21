class Solution {
    public boolean dfs(char[][] grid, boolean[][] visited, int r, int c,char ch,int pr,int pc) {
        visited[r][c]=true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for(int j=0;j<4;j++){
            int nr=dr[j]+r;
            int nc=dc[j]+c;
            if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length || grid[nr][nc]!=ch)continue;
            if(!visited[nr][nc]){
                if(dfs(grid,visited,nr,nc,ch,r,c))return true;
            }
            else if((nr!=pr || nc!=pc)){
                return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j,grid[i][j],-1,-1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
