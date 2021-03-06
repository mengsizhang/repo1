package com.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class offer34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, sum, path, res);
        return res;
    }

    public void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, sum, path, res);
        dfs(root.right, sum, path, res);
        path.removeLast();
    }
}
