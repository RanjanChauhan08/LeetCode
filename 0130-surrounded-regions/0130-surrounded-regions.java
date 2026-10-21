class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public void bfs(int[][]visited,char[][]board,int a,int b){
        board[a][b]='#';
        visited[a][b]=1;
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(a,b));
        int[]dr={0,1,0,-1};
        int[]dc={-1,0,1,0};
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                for(int j=0;j<4;j++){
                    int nr=dr[j]+p.r;
                    int nc=dc[j]+p.c;
                    if(nr<0 || nr>=board.length || nc<0 || nc>=board[0].length || visited[nr][nc]==1)continue;
                    if(board[nr][nc]=='O'){
                        board[nr][nc]='#';
                        queue.add(new pair(nr,nc));
                        visited[nr][nc]=1;
                    }
                }
            }
        }
    }
    public void solve(char[][] board) {
        int[][]visited=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((i==0 || i==board.length-1 || j==0 || j==board[0].length-1) && board[i][j]=='O' && visited[i][j]==0){
                    bfs(visited,board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}