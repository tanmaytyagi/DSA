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
        this.tail.prev = head;
    }

    public V get(K key) {
        if(!map.containsKey(key)) return null;
        Node<K,V> node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(K key, V value) {
        if(map.containsKey(key)) remove(map.get(key));
        Node<K,V> node = new Node<>(key, value);
    }

    private void remove(Node<K,V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node<K,V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
