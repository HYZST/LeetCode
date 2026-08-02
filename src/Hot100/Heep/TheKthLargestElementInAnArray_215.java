package Hot100.Heep;

import java.util.Random;

public class TheKthLargestElementInAnArray_215 {
/*
215. 数组中的第K个最大元素
中等
相关标签
premium lock icon
相关企业
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
示例 1:
输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
提示：
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
    public static void main(String[] args) {
        TheKthLargestElementInAnArray_215 obj=new TheKthLargestElementInAnArray_215();
        int[] a1={3,2,1,5,6,4};
        System.out.println(obj.findKthLargest(a1,2));
        int[] a2={3,2,3,1,2,4,5,5,6};
        System.out.println(obj.findKthLargest(a2,4));
    }
    private final Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        int target = k - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 随机pivot（保留你的逻辑）
            int pivotIdx = left + random.nextInt(right - left + 1);
            // 🔥 核心：替换为三路分区
            int[] pivot = threePartition(nums, left, right, pivotIdx);
            int lt = pivot[0], gt = pivot[1];
            // 三路判断：命中直接返回，否则只搜单边
            if (target <= gt && target >= lt) return nums[target];
            else if (target < lt) right = lt - 1;
            else left = gt + 1;
        }
        return -1;
    }
    // 🔥 三路分区：大 → 等 → 小（降序）
    private int[] threePartition(int[] nums, int left, int right, int pivotIdx) {
        int pivot = nums[pivotIdx];
        int lt = left;  // 大于pivot的右边界
        int gt = right; // 小于pivot的左边界
        int i = left;
        while (i <= gt) {
            if (nums[i] > pivot) {
                swap(nums, i++, lt++); // 放左边（大区域）
            } else if (nums[i] < pivot) {
                swap(nums, i, gt--);   // 放右边（小区域）
            } else {
                i++; // 等于区域，不动
            }
        }
        // 返回：大于区右边界lt，等于区右边界gt
        return new int[]{lt, gt};
    }
    // 交换函数（完全保留你的）
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
