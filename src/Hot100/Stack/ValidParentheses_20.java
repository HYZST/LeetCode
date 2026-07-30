package Hot100.Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_20 {
/*
20. 有效的括号
简单
相关标签
premium lock icon
相关企业
提示
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
示例 1：
输入：s = "()"
输出：true
示例 2：
输入：s = "()[]{}"
输出：true
示例 3：
输入：s = "(]"
输出：false
示例 4：
输入：s = "([])"
输出：true
示例 5：
输入：s = "([)]"
输出：false
提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
    public static void main(String[] args) {
        System.out.println("示例1: " + isValid("()"));       // 期望输出: true
        System.out.println("示例2: " + isValid("()[]{}"));   // 期望输出: true
        System.out.println("示例3: " + isValid("(]"));       // 期望输出: false
        System.out.println("示例4: " + isValid("([])"));     // 期望输出: true
        System.out.println("示例5: " + isValid("([)]"));     // 期望输出: false
    }
    private static boolean isValid(String s){
        if(s.length()%2!=0) return false;
        HashMap<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt( i);
            if(!map.containsKey(c)) stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if(map.get(c)!=top) return false;
            }
        }
        return stack.isEmpty();
    }
}
