package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC113PathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return ans;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        recur(root,sum-root.val,path);
        return ans;
    }
    private void recur(TreeNode node, int sum, List<Integer>path){
        if(node.left==null&&node.right==null){
            if(sum==0) ans.add(path);
            return;
        }
        if (node.left != null) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(node.left.val);
            recur(node.left, sum - node.left.val, newPath);
        }
        if(node.right!=null){
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(node.right.val);
            recur(node.right, sum - node.right.val, newPath);
        }

    }
}
