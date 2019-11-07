package com.leetcode.jolyon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC297SerializeandDeserializeBinaryTree {
    /**
     * Definition for a binary tree node. public class TreeNode { int val;
     * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public class CodecRecursive {
        StringBuilder sb = new StringBuilder();
        String str;

        // Encodes a tree to a single string.
        // 1,2,#,4,5
        public String serialize(TreeNode root) {
            if (root == null) {
                str = "#";
                return str;
            }
            sb = new StringBuilder();
            recur(root, sb);
            str = sb.toString();
            return str;
        }

        private void recur(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append('#');
                sb.append(',');
                return;
            }
            sb.append(node.val);
            sb.append(',');
            recur(node.left, sb);
            recur(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

            String tmp = queue.poll();
            if (tmp.equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(tmp));
            root.left = decode(queue);
            root.right = decode(queue);
            return root;
        }

        private TreeNode decode(Queue<String> queue) {
            String tmp = queue.poll();
            if (tmp.equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(tmp));
            root.left = decode(queue);
            root.right = decode(queue);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
