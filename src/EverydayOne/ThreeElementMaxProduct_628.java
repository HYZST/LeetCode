package EverydayOne;

public class ThreeElementMaxProduct_628 {
/*
    628. 三个数的最大乘积
已解答
简单
相关标签
premium lock icon
相关企业
给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
示例 1：
输入：nums = [1,2,3]
输出：6
示例 2：
输入：nums = [1,2,3,4]
输出：24
示例 3：
输入：nums = [-1,-2,-3]
输出：-6
提示：
3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */
    public static void main(String[] args) {
        int[] a1={1,2,3};
        int[] a2={1,2,3,4};
        int[] a3={-1,-2,-3};
        System.out.println(getProduct(a1));
        System.out.println(getProduct(a2));
        System.out.println(getProduct(a3));

    }
    //求三个数的最大乘积,只有两种情况
    //1.max1*max2*max3
    //2.max1*min1*min2
    public static int getProduct(int[] arr){
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        for (int i : arr) {
            if(i>max1){
                max3=max2;
                max2=max1;
                max1=i;
            } else if (i>max2) {
                max3=max2;
                max2=i;
            } else if (i>max3) {
                max3=i;
            }
            if(i<min1){
                min2=min1;
                min1=i;
            }else if(i<min2){
                min2=i;
            }
        }
        return Math.max((max1*max2*max3),(min1*min2*max1));
    }
}
