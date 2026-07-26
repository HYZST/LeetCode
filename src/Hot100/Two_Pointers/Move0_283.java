package Hot100.Two_Pointers;

import java.util.Arrays;

public class Move0_283 {
    /*
     * 283. 移动零
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 提示
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     * 提示:
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     * 进阶：你能尽量减少完成的操作次数吗？
     */
    public static void main(String[] args) {
        int n1[] = { 0, 1, 0, 3, 12 };
        int n2[] = { 0 };
        int n3[] = { 1, 7, 0, 4, 0, 2, 0, 0, 0, 4, 7, 0 };
        moveZeroes(n1);
        moveZeroes(n2);
        moveZeroes(n3);
    }

    /*
     * 遍历统计0个数,并进行删除0元素
     * 最后在数组末尾补齐0
     * 删除0的本质是让非0元素前移覆盖
     */
    public static void moveZeroes(int[] nums) {
        int cnt = 0;// cnt为指向0元素位置的索引值
        for (int i = 0; i < nums.length; i++) {
            // 当前元素为0,0元素索引值不变,等待覆盖
            // 不为0,根据记录的0的索引值,将非0元素覆盖到0元素的位置,实现删除0的效果
            if (nums[i] != 0)
                nums[cnt++] = nums[i];
        }
        // 补齐0
        // 删除0执行完后,cnt指向的是最后一个非0元素的下一个位置,可以作补0的开始位置
        for (int i = cnt; i < nums.length; i++)
            nums[i] = 0;
        System.out.println(Arrays.toString(nums));
    }
}
