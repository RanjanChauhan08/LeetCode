class DisJointSet{
    List<Integer>Parent=new ArrayList<>();
    List<Integer>Size=new ArrayList<>();
    public DisJointSet(int n){
        for(int i=0;i<=n;i++){
            Parent.add(i);
            Size.add(1);
        }
    }
    public int FindULP(int node){
        if(Parent.get(node)==node)return node;
        int pt=FindULP(Parent.get(node));
        Parent.set(node,pt);
        return pt;
    }
    public void UnionBySize(int u,int v){
        int ulu=FindULP(u);
        int ulv=FindULP(v);
        if(ulu==ulv)return;
        int SizeU=Size.get(ulu);
        int SizeV=Size.get(ulv);
        if(SizeU>SizeV){
            Parent.set(ulv,ulu);
            Size.set(ulu,SizeU+SizeV);
        }
        else {
            Parent.set(ulu,ulv);
            Size.set(ulv,SizeU+SizeV);
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]dr={0,1,0,-1};
        int[]dc={-1,0,1,0};
        DisJointSet ds=new DisJointSet(grid[0].length*grid.length);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    for(int z=0;z<4;z++){
                        int r=dr[z]+i;
                        int c=dc[z]+j;
                        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                            int n1=n*i+j;
                            int n2=n*r+c;
                            ds.UnionBySize(n1,n2);
                        }
                    }
                }
            }
        }
        int maxArea=0;
        boolean bt=true;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    bt=false;
                    Set<Integer>set=new HashSet<>();
                    for(int l=0;l<4;l++){
                        int da=dr[l]+i;
                        int db=dc[l]+j;
                        if(da>=0 && db>=0 && da<grid.length && db<grid[0].length && grid[da][db]==1){
                            int adjNode=da*n+db;
                            int adjNodeULP=ds.FindULP(adjNode);
                            set.add(adjNodeULP);
                        }
                    }
                    int area=1;
                    for(int node:set){
                        area=area+ds.Size.get(node);
                    }
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        if(bt)return (grid.length)*(grid[0].length);
        return maxArea;
    }
}