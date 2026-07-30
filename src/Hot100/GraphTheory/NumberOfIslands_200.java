package Hot100.GraphTheory;

public class NumberOfIslands_200 {
/*
200. 岛屿数量
中等
相关标签
premium lock icon
相关企业
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：
输入：grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
输出：1
示例 2：
输入：grid = [
  ['1','1','0','0','0'],
  ['1','1','0','0','0'],
  ['0','0','1','0','0'],
  ['0','0','0','1','1']
]
输出：3
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
 */
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numsIslands(grid1));
        System.out.println(numsIslands(grid2));
    }
    //深度优先搜索,把所有相连的岛屿搜索完后再遍历
    public static int numsIslands(char[][] grid){
        int row=grid.length;
        int col=grid[0].length;
        int cnt=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(grid,i,j,row,col);
                }
            }
        }
        return cnt;
    }
    private static void dfs(char[][] grid,int x,int y,int row,int col){
        if(x<0||y<0||x>=row||y>=col||grid[x][y]=='0') return;
        grid[x][y]='0';
        dfs(grid,x+1,y,row,col);
        dfs(grid,x-1,y,row,col);
        dfs(grid,x,y+1,row,col);
        dfs(grid,x,y-1,row,col);
    }
}
