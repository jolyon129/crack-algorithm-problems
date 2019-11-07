package com.leetcode.jolyon.bloomberg;

import java.util.Map;

public class TopFrequency {
    class DLinkedNode {
        int stockId;
        int count;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode left;
        DLinkedNode right;

        DLinkedNode(int id, int count) {
            this.count = count;
            this.stockId = id;
        }
    }

    Map<Integer, DLinkedNode> stockToNode;
    Map<Integer, DLinkedNode> freqToHeadOfLinkeList;
    DLinkedNode headofHeads = new DLinkedNode(-1, -1);

    TopFrequency() {
        DLinkedNode newHead = new DLinkedNode(-1, -1);
        freqToHeadOfLinkeList.put(1, newHead);
        headofHeads.left = newHead;
    }

    void update(int stockId) {
        int freq;
        if (!stockToNode.containsKey(stockId)) {
            freq = 1;
            DLinkedNode newNode = new DLinkedNode(stockId, freq);
            stockToNode.put(stockId, newNode);
            insertNewStockToFreq(freqToHeadOfLinkeList.get(freq), newNode);
        } else {
            DLinkedNode node = stockToNode.get(stockId);
            int oldFreq = node.count;
            int newFreq = ++node.count;
            if (freqToHeadOfLinkeList.containsKey(newFreq)) {
                if (freqToHeadOfLinkeList.get(newFreq).next == null) {
                    // connect heads
                    connectHeads(freqToHeadOfLinkeList.get(newFreq),
                            freqToHeadOfLinkeList.get(oldFreq),
                            freqToHeadOfLinkeList.get(oldFreq).right);
                }
                // add new stock to this frequency
                DLinkedNode freqHead = freqToHeadOfLinkeList.get(newFreq);
                insertNewStockToFreq(freqHead, node);
                // remove old head from head chain
                if(freqToHeadOfLinkeList.get(oldFreq).next==null){
                    removeHeadfromHeadChain(freqToHeadOfLinkeList.get(oldFreq));
                }

            } else {
                removeNode(node);
                DLinkedNode newHeadOfLinkedlist = new DLinkedNode(-1, -1);
                // Update the left pointer
                freqToHeadOfLinkeList.put(newFreq, newHeadOfLinkedlist);
                DLinkedNode originalLeft = headofHeads.left;
                headofHeads.left = newHeadOfLinkedlist;
                newHeadOfLinkedlist.left = originalLeft;
            }


        }
    }


    void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
    }

    void removeHeadfromHeadChain(DLinkedNode node) {
        DLinkedNode left = node.left;
        DLinkedNode right= node.right;
        right.left = left;
        if (left!= null) {
            left.right = right;
        }
    }

    void connectHeads(DLinkedNode node, DLinkedNode left, DLinkedNode right) {
        left.right = node;
        node.left = left;
        node.right = right;
        right.left = node;
    }

    void insertNewStockToFreq(DLinkedNode head, DLinkedNode node) {
        DLinkedNode next = head.next;
        node.prev = head;
        node.next = next;
        head.next = node;
        if (next != null) {
            next.prev = node;
        }
    }


}
