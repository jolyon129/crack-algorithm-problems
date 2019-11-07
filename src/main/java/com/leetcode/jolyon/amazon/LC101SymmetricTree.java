package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC101SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return compare(root.left, root.right);
        }

        private boolean compare(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null || p.val != q.val) return false;
            return compare(p.left, q.right) && compare(p.right, q.left);
        }
    }

    class IterativeSolution {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode t1 = q.poll();
                TreeNode t2 = q.poll();
                if (t1 == null && t2 == null) continue;
                if (t1 == null || t2 == null) return false;
                if (t1.val != t2.val) return false;
                q.add(t1.left);
                q.add(t2.right);
                q.add(t1.right);
                q.add(t2.left);
            }
            return true;

        }
    }
}
