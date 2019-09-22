package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC572SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(s);
        while(queue.size()!=0){
            TreeNode node = queue.pollFirst();
            if(isSame(node,t)) return true;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return false;
    }
    private boolean isSame(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if( p==null || q==null || p.val!=q.val) return false;
        return isSame(p.left, q.left) & isSame(p.right, q.right);
    }
}
