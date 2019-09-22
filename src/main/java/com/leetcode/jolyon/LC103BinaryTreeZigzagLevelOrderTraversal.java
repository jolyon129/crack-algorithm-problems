package com.leetcode.jolyon;

import java.util.*;

public class LC103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root ==null) return res;
        queue.add(root);
        int level= 0;
        while(queue.size()!=0){
            level++;
            int len = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node = queue.pollFirst();
                if(node.left!=null) queue.offerLast(node.left);
                if(node.right!=null) queue.offerLast(node.right);
                levelList.add(node.val);
            }
            if(level%2==0){
                Collections.reverse(levelList);
            }
            res.add(levelList);

        }
        return res;
    }
}
