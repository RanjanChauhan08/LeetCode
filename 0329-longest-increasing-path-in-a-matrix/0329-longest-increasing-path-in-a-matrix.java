class pair{
    int node;
    int dist;
    pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        int n=matrix.length;
        int m=matrix[0].length;
        boolean check=false;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n*m;i++)adj.add(new ArrayList<>());
        int[]dx={0,1,0,-1};
        int[]dy={-1,0,1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int node=matrix[i][j];
                for(int x=0;x<4;x++){
                    int nx=dy[x]+i;
                    int ny=dx[x]+j;
                    if(nx<0 || nx>=n || ny<0 || ny>=m)continue;
                    if(matrix[nx][ny]<=matrix[i][j])continue;
                    int a=m*i+j;
                    int b=m*nx+ny;
                    adj.get(a).add(b);
                    check=true;
                }
            }
        }
        if(!check)return 1;
        int[] dist = new int[n*m];

        for(int i = 0; i < n*m; i++) {

            if(dist[i] == 0) {

                Queue<pair> queue = new LinkedList<>();
                queue.add(new pair(i, 1));
                dist[i] = 1;

                while(!queue.isEmpty()) {

                    pair p = queue.poll();

                    int node = p.node;
                    int d = p.dist;

                    max = Math.max(max, d);

                    for(Integer newNode : adj.get(node)) {

                        if(d + 1 > dist[newNode]) {

                            dist[newNode] = d + 1;

                            queue.add(new pair(newNode, d + 1));
                        }
                    }
                }
            }
        }
        return max;
    }
}