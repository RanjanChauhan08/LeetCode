class pair{
    int r=0;
    int c=0;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org=image[sr][sc];
        if (org == color) {
            return image;
        }
        int[][]visited=new int[image.length][image[0].length];
        image[sr][sc]=color;
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(sr,sc));
        int[]x={0,1,0,-1};
        int[]y={-1,0,1,0};
        image[sr][sc]=color;
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                pair p=queue.poll();
                visited[p.r][p.c]=1;
                for(int j=0;j<4;j++){
                    int n=x[j]+p.r;
                    int m=y[j]+p.c;
                    if(n>=0 && n<image.length && m>=0 && m<image[0].length && image[n][m]==org && visited[n][m]==0){
                        queue.add(new pair(n,m));
                        image[n][m]=color;
                    }
                }
            }
        }
        return image;
    }
}