package Hot100.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
/*
46. 全排列
中等
相关标签
premium lock icon
相关企业
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：
输入：nums = [1]
输出：[[1]]
提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
 */
    boolean[] used;
    List<List<Integer>> res=new ArrayList<>();//存可能排列顺序的集合
    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={0,1};
        int[] nums3={1};
        Permutations_46 obj=new Permutations_46();
        System.out.println(obj.permute(nums1));
        System.out.println(obj.permute(nums2));
        System.out.println(obj.permute(nums3));
    }
    //深度优先搜索思想,将每个结果都经过一次
    //因为元素不重复,可以用一个数组记录哪些数字是否出现过,出现过的不会再被选择
    public List<List<Integer>> permute(int[] nums){
        res.clear();
        int n=nums.length;
        used=new boolean[n];
        backtrack(nums,new ArrayList<>());
        return res;
    }
    //回溯算法
    private void backtrack(int[] nums,List<Integer> path){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            path.add(nums[i]);
            backtrack(nums,path);
            path.remove(path.size()-1);//回溯到上一步,把path的最后一个选择删去
            used[i]=false;
        }
    }
}
