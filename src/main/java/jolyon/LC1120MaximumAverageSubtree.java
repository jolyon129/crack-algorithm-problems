package com.leetcode.jolyon;

public class LC1120MaximumAverageSubtree {
    double maxAvg = -1;
    public double maximumAverageSubtree(TreeNode root) {
        int[] info=recur(root);
        return maxAvg;
    }
    private int[] recur(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] lInfo = recur(root.left);
        int[] rInfo = recur(root.right);
        int sum = lInfo[0]+rInfo[0] + root.val;
        int count = lInfo[1]+rInfo[1] + 1;
        double avg = (double)sum/(double)count;
        if(avg>this.maxAvg) this.maxAvg = avg;
        return new int[]{sum, count};
    }
}
