class Solution {
    static boolean[][] visited;
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,n,m);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int i,int j,char[][] grid,int n,int m){
        visited[i][j]=true;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        for(int k=0;k<4;k++){
            int ni=dx[k]+i;
            int nj=dy[k]+j;
            if(ni<n && nj<m && ni>=0 && nj>=0 && grid[ni][nj]=='1' && !visited[ni][nj]){

                dfs(ni,nj,grid,n,m);
            }
        }
    }
}
