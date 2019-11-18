package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC106ConstructBinaryTreefromInorderandPostorderTraversal {
    Map<Integer, Integer> map = new HashMap<>();
    int post_idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        post_idx = postorder.length - 1;
        return recur(0, inorder.length, inorder, postorder);
    }
    TreeNode recur(int in_left, int in_right,int[] inorder, int[] postorder){
        if(post_idx<0||in_left==in_right) return null;
        TreeNode root = new TreeNode(postorder[post_idx]);
        post_idx--;
        int idx = map.get(root.val);
        // Do recursion on right first!
        root.right = recur(idx + 1, in_right, inorder, postorder);
        root.left = recur(in_left, idx, inorder, postorder);
        return root;
    }

}
