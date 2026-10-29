class pair{
    int r;
    int c;
    int dis;
    pair(int r,int c,int dis){
        this.r=r;
        this.c=c;
        this.dis=dis;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)return -1;
        int[][]visited=new int[grid.length][grid[0].length];
        visited[0][0]=1;
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(0,0,1));
        int[]dr={-1,-1,-1,0,1,1,1,0};
        int[]dc={-1,0,1,1,1,0,-1,-1};
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                if(p.r==grid.length-1 && p.c==grid[0].length-1)return p.dis;
                for(int a=0;a<8;a++){
                    int nr=dr[a]+p.r;
                    int nc=dc[a]+p.c;
                    if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length || grid[nr][nc]==1 || visited[nr][nc]==1)continue;
                    visited[nr][nc]=1;
                    queue.add(new pair(nr,nc,p.dis+1));
                }
            }
        }
        return -1;
    }
}