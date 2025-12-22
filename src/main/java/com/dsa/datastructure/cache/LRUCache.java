package com.dsa.datastructure.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node<K,V>> map;
    private final Node<K,V> head;
    private final Node<K,V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public void put(K key, V value) {
        if(map.containsKey(key)) removeNode(map.get(key));
        Node<K,V> newNode = new Node<>(key, value);
        insertToFront(newNode);
        map.put(key, newNode);

        if(map.size() > capacity) {
            Node<K,V> LruNode = tail.prev;
            removeNode(LruNode);
            map.remove(LruNode.key);
        }
    }

    public V get(K key) {
        if(!map.containsKey(key)) return null;
        Node<K,V> node = map.get(key);
        removeNode(node);
        insertToFront(node);
        return node.value;
    }

    private void removeNode(Node<K,V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node<K,V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int currentSize() {
        return map.size();
    }

    public void printCache() {
        Node<K,V> current = head.next;
        while(current != tail) {
            System.out.println(current.key + ": " + current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(4);
        cache.put("first", 1);
        cache.put("second", 2);
        cache.put("third", 3);
        cache.put("fourth", 4);
        cache.put("fifth", 5);
        cache.put("sixth", 6);
        System.out.println(cache.get("third"));
        cache.printCache();
        System.out.println(cache.currentSize());
    }
}
