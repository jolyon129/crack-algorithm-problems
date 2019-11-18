package com.leetcode.jolyon.bloomberg;

import java.util.Hashtable;

public class LC146LRUCache {
    static class LRUCache {
        private Hashtable<Integer, DLinkedNode> cache =
                new Hashtable<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }
        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            // head.prev = null;

            tail = new DLinkedNode();
            // tail.child = null;

            head.next = tail;
            tail.prev = head;
        }
        // Insert to the tail
        private void insert(DLinkedNode node){
            DLinkedNode prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        private void remove(DLinkedNode node){
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            next.prev = prev;
            prev.next = next;
        }



        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;

            // move the accessed node to the tail;
            remove(node);
            insert(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                insert(newNode);

                if(cache.size() > capacity) {
                    // remove the one after head
                    // Remove from cache first!!
                    cache.remove(head.next.key);
                    remove(head.next);
                }
            } else {
                // update the value.
                node.value = value;
                remove(node);
                insert(node);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
