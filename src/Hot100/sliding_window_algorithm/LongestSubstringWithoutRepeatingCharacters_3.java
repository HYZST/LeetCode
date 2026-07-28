package Hot100.sliding_window_algorithm;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
/*
3. 无重复字符的最长子串
已解答
中等
相关标签
premium lock icon
相关企业
提示
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
提示：
0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
    public static void main(String[] args) {
        String s1="abcabcbb";
        String s2="bbbbb";
        String s3="pwwkew";
        System.out.println(getNumber(s1));
        System.out.println(getNumber(s2));
        System.out.println(getNumber(s3));
    }
    public static int getNumber(String s){
        /*
        利用双指针,左指针不动,右指针遍历,每次遍历将对应元素推入哈希表
        哈希表存元素以及出现位置下标,右指针遍历到的元素先判断是否在哈希表中存在
        存在就移动左指针到出现位置的下一位置,每次遍历都计算右指针减去左指针加1,
        将其存入maxLen中,每次都计算并取最大值,最后返回的就是出现过的最长字串的长度
         */
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(map.containsKey(c)){
                left=map.get(c)+1;
            }
            map.put(c,right);
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
