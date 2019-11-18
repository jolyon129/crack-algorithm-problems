package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.*;

public class LC314BinaryTreeVerticalOrderTraversal {
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> maps = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        bfs(root, maps);
        for (int i = minValue; i<=maxValue;i++) {
            res.add(maps.get(i));
        }
        return res;
    }

    void bfs(TreeNode root, Map<Integer,List<Integer>> maps) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        cols.add(0);
        queue.add(root);
        while (!queue.isEmpty()){
            int col = cols.poll();
            TreeNode node = queue.poll();
            maps.putIfAbsent(col, new ArrayList<>());
            maps.get(col).add(node.val);
            minValue = Math.min(col, minValue);
            maxValue = Math.max(maxValue, col);
            if(node.left!=null){
                queue.add(node.left);
                cols.add(col - 1);
            }
            if(node.right!=null){
                queue.add(node.right);
                cols.add(col + 1);
            }
        }
    }
}
