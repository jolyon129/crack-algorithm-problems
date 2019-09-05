package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC111MinDepthOfBT {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return recur(root);
    }
    private int recur(TreeNode root){
        if(root.left==null && root.right==null){
            return 1;
        }else if(root.left!=null && root.right ==null){
            return 1 + recur(root.left);
        }else if(root.right!=null && root.left==null){
            return 1 + recur(root.right);
        }else{
            return Math.min(recur(root.left),recur(root.right))+1;
        }
    }
}

/**
 * BFS is better in this case
 */
class sol2{
    public int minDepth(TreeNode root) {
        if(root==null) return 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int min_depth = 0;
        while(!queue.isEmpty()){
            min_depth++;
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.poll();
                if(node.left==null&&node.right==null){
                    queue.clear();
                    break;
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;
            }
        }
        return min_depth;
    }
}