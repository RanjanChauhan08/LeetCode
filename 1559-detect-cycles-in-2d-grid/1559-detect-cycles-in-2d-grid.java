class pair{
    int r;
    int c;
    int pr;
    int pc;
    pair(int r,int c,int pr,int pc){
        this.r=r;
        this.c=c;
        this.pr=pr;
        this.pc=pc;
    }
}
class Solution {
    public boolean bfs(char[][] grid, boolean[][] visited, int r, int c) {
        Queue<pair>queue=new LinkedList<>();
        visited[r][c]=true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        queue.add(new pair(r,c,-1,-1));
        int len=0;
        while(!queue.isEmpty()){
            int s=queue.size();
            len++;
            for(int i=0;i<s;i++){
                pair p=queue.poll();
                for(int j=0;j<4;j++){
                    int nr=dr[j]+p.r;
                    int nc=dc[j]+p.c;
                    if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length || grid[nr][nc]!=grid[r][c])continue;
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        queue.add(new pair(nr,nc,p.r,p.c));
                    }
                    else if((nr!=p.pr || nc!=p.pc)){
                        return true;
                    }
                }
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
                    if (bfs(grid, visited, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
