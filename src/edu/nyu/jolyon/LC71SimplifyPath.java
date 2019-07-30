package edu.nyu.jolyon;

import java.util.*;

public class LC71SimplifyPath {
    public String simplifyPath(String path) {
        String[] array = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals("")) continue;
            if (!array[i].equals(".") && !array[i].equals("..")) {
                stack.add(array[i]);
            } else if (array[i].equals("..")) {
                stack.pollLast();
            }
        }
//        String str = "/";
        return "/"+String.join("/", stack);
    }
}
