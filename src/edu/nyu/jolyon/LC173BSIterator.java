package edu.nyu.jolyon;

import java.util.ArrayDeque;

public class LC173BSIterator {

    public static class BSTIterator {
        ArrayDeque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque<TreeNode>();
            travelLeft(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.poll();
            if (node.right != null) {
                travelLeft(node.right);
            }
            return node.val;
        }

        private void travelLeft(TreeNode root) {
//            stack.add(node);
//            node = stack.getLast();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if(stack.isEmpty()){
                return false;
            }else{
                return true;
            }

        }
    }
}
