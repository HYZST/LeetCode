package Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal_94 {
/*
94. 二叉树的中序遍历
已解答
简单
相关标签
premium lock icon
相关企业
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
    public static void main(String[] args) {
        // 测试用例1：root = [1,null,2,3]  预期输出 [1,3,2]
        TreeNode tree1 = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3),
                        null
                )
        );
        System.out.println("用例1结果：" + inOrderTraversal(tree1));

        // 测试用例2：空树 []
        TreeNode tree2 = null;
        System.out.println("用例2结果：" + inOrderTraversal(tree2));

        // 测试用例3：单个节点 [1]
        TreeNode tree3 = new TreeNode(1);
        System.out.println("用例3结果：" + inOrderTraversal(tree3));
    }
    public static List<Integer> inOrderTraversal(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        dfs(root,res);
        return res;
    }
    public static void dfs(TreeNode root, ArrayList<Integer> res){
        if(root==null) return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }
    // 二叉树节点
    public static class TreeNode {
        // 节点值
        int val;
        // 左孩子
        TreeNode left;
        // 右孩子
        TreeNode right;

        // 三个构造方法（LeetCode原版）
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
