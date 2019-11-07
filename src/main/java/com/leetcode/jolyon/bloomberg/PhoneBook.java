package com.leetcode.jolyon.bloomberg;

import java.util.Map;

public class PhoneBook {
    class Person{
        int phone;
        int name;
    }
    class TrieNode {
        TrieNode[] links;
        int value;
        boolean isAWord;
        Person[] list;
        TrieNode(int value) {
            links = new TrieNode[26];
            this.value = value;
            this.isAWord = false;
            this.list = new Person[10];
        }
    }
    Map<Integer, String> phoneToName;
    TrieNode head = new TrieNode(-1);

}
