package com.leetcode.jolyon;

public class LC98ValidateBST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return true;
            }
            // This does not work!!!
            // return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
            return validate(root,null,null);
        }
        private boolean validate(TreeNode root, Integer lo, Integer hi){
            if(root==null){
                return true;
            }
            boolean leftR = false;
            boolean rightR =false;
            int value = root.val;
            if(lo==null||(lo!=null && value>lo)){
                leftR = validate(root.left,lo,value);
            }

            if(hi==null||(hi!=null && value<hi)){
                rightR = validate(root.right,value,hi);
            }
            if(leftR&&rightR){
                return true;
            }else{
                return false;
            }
        }
    }
}
