package com.leetcode.jolyon.bloomberg;

public class Marathon {
    class DLinkedNode {
        int runnerId;
        int rank;
        DLinkedNode prev;
        DLinkedNode next;
        DLinkedNode left;
        DLinkedNode(int id, int rank){
            this.runnerId = id;
            this.rank = rank;
        }
    }
    class trackBoard {
        DLinkedNode[] cpIdToHead;
        DLinkedNode[] runnerToNode;
        int[] rankAtCP;
        DLinkedNode headOfHeads;//connect those sparse heads of linked list
        public trackBoard(int numOfRunner, int numOfCheckPoint) {
            cpIdToHead = new DLinkedNode[numOfCheckPoint];
            runnerToNode = new DLinkedNode[numOfRunner];
            rankAtCP = new int[numOfCheckPoint];
            headOfHeads = new DLinkedNode(-1,-1);
            for(int i=0;i<numOfCheckPoint;i++){
                cpIdToHead[i] = new DLinkedNode(-1, -1);
            }
            headOfHeads.next = cpIdToHead[0];
//            cpIdToHead[0].prev = headOfHeads;
            headOfHeads.left = cpIdToHead[0].prev;
            for(int i=0;i<numOfRunner;i++){
                // All runners start at cp0;
                DLinkedNode node = new DLinkedNode(i, 0);
                insertToHead(cpIdToHead[i], node);
                rankAtCP[0] = numOfRunner;
            }

        }
        public void update(int runnerId, int cpId){
            DLinkedNode node = runnerToNode[runnerId];
            removeNode(node);
            DLinkedNode head = cpIdToHead[cpId];
            insertToHead(head, node);
            rankAtCP[cpId]++;
            if(head.next==null){
                removeNode(head);
            }
        }
        public DLinkedNode topK(int k){
            return headOfHeads;
        }
        private void removeNode(DLinkedNode node){
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
        private void insertToHead(DLinkedNode head, DLinkedNode node){
            DLinkedNode tmp = head.next;
            head.next = node;
            node.prev = head;
            tmp.prev = node;
            node.next = tmp;
        }

    }

}
