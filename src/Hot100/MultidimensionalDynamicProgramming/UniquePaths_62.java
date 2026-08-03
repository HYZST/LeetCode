package Hot100.MultidimensionalDynamicProgramming;

public class UniquePaths_62 {
/*
62. 不同路径
中等
相关标签
premium lock icon
相关企业
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？
示例 1：
输入：m = 3, n = 7
输出：28
示例 2：
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：
输入：m = 7, n = 3
输出：28
示例 4：
输入：m = 3, n = 3
输出：6
提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109
 */
    public static void main(String[] args) {
        System.out.println(uniquePaths1(3, 7));
        System.out.println(uniquePaths1(3, 2));
        System.out.println(uniquePaths2(3, 7));
        System.out.println(uniquePaths2(3, 2));
    }
    //数学方式解决:向右和向下移动的次数固定,计算全排列
    public static int uniquePaths1(int m, int n) {
        if(m==1||n==1) return 1;
        long total=m+n-2;
        long k=Math.min(m-1,n-1);
        long res=1;
        for(int i=1;i<=k;i++){
            res=res*(total-k+i)/i;
        }
        return (int)res;
    }
    //使用动态规划
    //机器人只能向下或右移动,那么它只能从上或左方移动而来
    //那么一个位置的路径数=左侧路径数+上路径数
    //第一行/列单独初始化为1(只有一种路径)
    public static int uniquePaths2(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) dp[i][0]=1;//第一列
        for(int j=0;j<n;j++) dp[0][j]=1;//第一行
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //去掉第一行/列再计算
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        //返回最后一个位置的路径数
        return dp[m-1][n-1];
    }
}
