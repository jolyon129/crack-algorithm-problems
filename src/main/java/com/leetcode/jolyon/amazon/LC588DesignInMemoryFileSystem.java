package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC588DesignInMemoryFileSystem {
    public class FileSystem {

        Node root;

        public FileSystem() {
            root = new Node("/");
        }

        public List<String> ls(String path) {

            Node nd = traverse(path);

            List<String> res = new ArrayList<String>();

            if (nd.isFile) {
                res.add(nd.name);
            } else {
                for (String child : nd.children.keySet()) {
                    res.add(child);
                }
            }

            return res;
        }

        public void mkdir(String path) {

            traverse(path);
        }

        public void addContentToFile(String filePath, String content) {

            Node nd = traverse(filePath);
            nd.isFile = true;
            nd.content.append(content);
        }

        public String readContentFromFile(String filePath) {

            Node nd = traverse(filePath);
            return nd.content.toString();
        }

        private Node traverse(String filePath) {
            String[] arr = filePath.split("/");
            Node curr = root;

            // start from index 1 as 0th element is ""
            for (int i = 1; i < arr.length; i++) {
                if (!curr.children.containsKey(arr[i])) {
                    Node nd = new Node(arr[i]);
                    curr.children.put(arr[i], nd);
                }

                curr = curr.children.get(arr[i]);
            }

            return curr;
        }

        public class Node {
            String name;
            boolean isFile;
            StringBuilder content;
            Map<String, Node> children;

            public Node(String name) {
                this.content = new StringBuilder();
                this.name = name;
                this.children = new TreeMap<String, Node>();
            }
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
}
