package edu.nyu.jolyon;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;

public class LC99RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if(root.left==null&& root.right==null){
            return;
        }
        addThread(root);
        if(root.right!=null){
            addThread(root.right);
        }
        checkAndSwap(root);
    }
    private void addThread(TreeNode root){
        TreeNode node = root;
        while (node.left!=null){
            TreeNode predecessor = node;
            // Go one step deep
            node = node.left;
            // Keep searching on the right subtree
            while (node.right!=null){
                node = node.right;
            }
            // Add thread
            node.right = predecessor;
            // Back to the predecessor.left
            node = predecessor.left;
        }
    }
    private void checkAndSwap(TreeNode root){
        TreeNode start_node = root;
        while(start_node.left!=null){
            start_node = start_node.left;
        }
        ArrayList<TreeNode> to_be_swapped = new ArrayList<>();
        TreeNode first=start_node;
        TreeNode second=start_node;
        TreeNode prev = start_node;
        while(start_node.right!=null){
            prev = start_node;
            start_node = start_node.right;
            if(prev.val> start_node.val){
                first = prev;
                second = start_node;
                break;
            }
        }
        while (start_node.right!=null){
            prev = start_node;
            start_node = start_node.right;
            if(second.val>start_node.val){
                second = start_node;
                break;
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }
    public void recoverTree1(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        while(root!=null){
            if(root.left!=null){
                // Connect threading for root
                temp = root.left;
                while(temp.right!=null && temp.right != root){
                    temp = temp.right;
                }
                // If teamp.right == root, the threading already exists
                // We can try to find the misplaced node
                if(temp.right!=null){
                    if(pre!=null && pre.val > root.val){
                        if(first==null){first = pre;second = root;}
                        else{second = root;}
                    }
                    pre = root;
                    // Remove the fake right
                    temp.right = null;
                    root = root.right;
                }else{
                    // Construct the threading
                    temp.right = root;
                    root = root.left;
                }
            }else{
                if(pre!=null && pre.val > root.val){
                    if(first==null){first = pre;second = root;}
                    else{second = root;}
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if(first!= null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
