package edu.nyu.jolyon;

public class LC117PopulatingNextRightPointers {
    public Node connect(Node root) {
        Node parent = root;
        Node child = null, childHead=null;
        while (parent!=null){
            while (parent!=null){
                if(parent.left!=null){
                    if(childHead!=null){
                        child.next = parent.left;
                    }else{
                        childHead = parent.left;
                    }
                    child =  parent.left;
                }
                if(parent.right!=null){
                    if(childHead!=null){
                        child.next = parent.right;
                    }else{
                        childHead = parent.right;
                    }
                    child =  parent.right;
                }
                parent = parent.next;
            }
            parent = childHead;
            child = null;
            childHead = null;
        }
        return root;
    }
}
