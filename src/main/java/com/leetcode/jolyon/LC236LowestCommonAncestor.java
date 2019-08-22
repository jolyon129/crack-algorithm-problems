package com.leetcode.jolyon;

import java.util.*;

public class LC236LowestCommonAncestor {
    static class MyTerribleSolution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Deque<TreeNode> path1 = new ArrayDeque<>();
            Deque<TreeNode> path2 = new ArrayDeque<>();
            path1.add(root);
            path2.add(root);
            dfs(root, p.val, path1);
            dfs(root, q.val, path2);
            int len = Math.min(path1.size(), path2.size());
            TreeNode prev = root;
            for (int i = 0; i < len; i++) {
                TreeNode node1 = path1.pollFirst();
                TreeNode node2 = path2.pollFirst();
                if (node1.val != node2.val) {
                    break;
                }
                prev = node1;
            }
            return prev;
        }

        private boolean dfs(TreeNode root, int target, Deque<TreeNode> path) {
            if (root.val == target) {
                return true;
            }
            if (root.left!=null) {
                path.add(root.left);
                boolean found = dfs(root.left, target, path);
                if (found) {
                    return true;
                } else {
                    path.pollLast();
                }
            }
            if (root.right!=null) {
                path.add(root.right);
                boolean found = dfs(root.right, target, path);
                if (found) {
                    return true;
                } else {
                    path.pollLast();
                }
            }
            return false;

        }
    }
}
