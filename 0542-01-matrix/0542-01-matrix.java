class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][]ans=new int[mat.length][mat[0].length];
        Queue<pair>queue=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    queue.add(new pair(i,j));
                }
                else{
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int[]dr={0,1,0,-1};
        int[]dy={-1,0,1,0};
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                for(int j=0;j<4;j++){
                    int nr=dr[j]+p.r;
                    int nc=dy[j]+p.c;
                    if(nr<0 || nr>=mat.length || nc<0 || nc>=mat[0].length)continue;
                    if(ans[nr][nc]==Integer.MAX_VALUE){
                        ans[nr][nc]=ans[p.r][p.c]+1;
                        queue.add(new pair(nr,nc));
                    }
                }
            }
        }
        return ans;
    }
}