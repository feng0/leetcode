package com.leetcode.l146LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){
            key = _key;
            value = _value;
        }
    }
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        //如果存在，移动到最前端
        moveTohead(node);
        return head.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            //添加hash表
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value= value;
            moveTohead(node);
        }
    }

    public void moveTohead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    public void removeNode(DLinkedNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public void addToHead(DLinkedNode node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;

    }
    public DLinkedNode removeTail(){
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}
