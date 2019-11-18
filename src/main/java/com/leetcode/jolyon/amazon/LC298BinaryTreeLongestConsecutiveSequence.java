package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

public class LC298BinaryTreeLongestConsecutiveSequence {
    int ans = 0;

    public int longestConsecutive(TreeNode root) {
        recur(0, 0, root);
        return ans;
    }

    void recur(int prevEnding, int prevPath, TreeNode node) {
        if (node == null) return;
        int curPath = 1;
        if (prevPath != 0 && node.val == prevEnding + 1) {
            curPath = prevPath + 1;
        }
        ans = Math.max(ans, curPath);
        recur(node.val, curPath, node.left);
        recur(node.val, curPath, node.right);
    }
}
