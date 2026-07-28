package Hot100.Matrix;

import java.util.Arrays;

public class SetMatrixZeros_73 {
/*
73. 矩阵置零
已解答
中等
相关标签
premium lock icon
相关企业
提示
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
示例 1：
输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
示例 2：
输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
提示：
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
进阶：
一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？
 */
    public static void main(String[] args) {
        int[][] m1={{1,1,1},{1,0,1},{1,1,1}};
        int[][] m3={{1,1,1},{1,0,1},{1,1,1}};
        int[][] m2={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] m4={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        getMatrix1(m1);
        getMatrix1(m2);
        getMatrix2(m3);
        getMatrix2(m4);
    }
    //空间:O(m+n)-使用两个数组记录0出现位置的行数和列数,两次遍历数组
    public static void getMatrix1(int[][] arr){
        int m= arr.length;
        int n=arr[0].length;
        boolean[] row=new boolean[m];
        boolean[] col=new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i]||col[j]){
                    arr[i][j]=0;
                }
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
    //O(1)-不用额外数组,复用数组第一行,第一列充当标记数组,只需要两变量
    //保存第一行,第一列自身是否要清零
    public static void getMatrix2(int[][] arr){
        int m= arr.length;
        int n=arr[0].length;
        boolean row0=false,col0=false;
        //分别判断第一行和第一列有无0
        for(int i=0;i<m;i++){//列
            if(arr[i][0]==0) col0=true;
        }
        for(int j=0;j<n;j++){//行
            if(arr[0][j]==0) row0=true;
        }

        //遍历除第一行第一列外其他元素
        //如果存在0,则把对应标记置0
        /*
        如果第2行第3列元素为0,则将arr[0][1]和arr[2][0]两个位置元素置0
         */
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[i][j]==0){
                    //将需要置0的列标记出来
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }
        //根据标记将对应行和对应列置0
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr[i][0]==0||arr[0][j]==0)
                    arr[i][j]=0;
            }
        }
        //最后处理第一行和第一列
        if(row0) for(int j=0;j<n;j++) arr[0][j]=0;
        if(col0) for(int i=0;i<m;i++) arr[i][0]=0;
        //遍历输出
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
