package Hot100.String;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
/*
560. 和为 K 的子数组
已解答
中等
相关标签
premium lock icon
相关企业
提示
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。
示例 1：
输入：nums = [1,1,1], k = 2
输出：2
示例 2：
输入：nums = [1,2,3], k = 3
输出：2
提示：
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
    public static void main(String[] args) {
        int[] a1={1,1,1};
        int[] a2={1,2,3};
        System.out.println(getEquals(a1, 2));
        System.out.println(getEquals(a2, 3));
    }
    public static int getEquals(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int currentSum=0;
        int cnt=0;
        for (int i : arr) {
            currentSum+=i;
            if(map.containsKey(currentSum-k)){
                //计数器累加,累加的是差前缀和出现的次数
                cnt+=map.get(currentSum-k);
            }
            map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        }
        return cnt;
    }
}
