package com.leetcode.jolyon;

public class LC117PopulatingNextRightPointers {
    public Node connect(Node root) {
        Node parentHead = root;
        Node current = null, currentHead=null;
        while (parentHead!=null){
            // Move parent pointer on the current parent level
            Node parentPointer = parentHead;
            while (parentPointer!=null){
                if(parentPointer.left!=null){
                    if(currentHead!=null){
                        current.next = parentPointer.left;
                        current = current.next;
                    }else{
                        currentHead = parentPointer.left;
                        current = currentHead;
                    }
                }
                // Try to connect parentPointer.right
                if(parentPointer.right!=null){
                    if(currentHead!=null){
                        current.next = parentPointer.right;
                        current = current.next;
                    }else{
                        currentHead = parentPointer.right;
                        current = currentHead;
                    }
                }
                // Iterate the same level by "next" pointer
                parentPointer = parentPointer.next;
            }
            // Move parent to the next level
            parentHead = currentHead;
            // clear up
            current = null;
            currentHead = null;
        }
        return root;
    }
}
