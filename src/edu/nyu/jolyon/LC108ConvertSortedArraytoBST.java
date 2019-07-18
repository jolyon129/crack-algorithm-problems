package edu.nyu.jolyon;

public class LC108ConvertSortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)return null;
        return  helper(nums, 0, nums.length - 1, null);
    }

    TreeNode helper(int[] nums, int start, int end, TreeNode node) {

        if (end >= start) {
            if (start == end) return new TreeNode(nums[start]);
            int mid = (int) Math.ceil((start + end) / 2);
            node = new TreeNode(nums[mid]);
            node.left = helper(nums, start, mid - 1, node.left);
            node.right = helper(nums, mid + 1, end, node.right);
        }
        return node;
    }
}
