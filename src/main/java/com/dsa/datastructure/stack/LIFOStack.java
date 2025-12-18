package com.dsa.datastructure.stack;

public class LIFOStack<T> {

    private static class Node<T> {
        T val;
        Node<T> next;
        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public LIFOStack() {
        head = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public T pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Node<T> node = head;
        head = head.next;
        size--;
        return node.val;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LIFOStack<String> s = new LIFOStack<String>();
        s.push("apple");
        s.push("ball");
        s.push("orange");
        System.out.println(s.peek());
        s.pop();
        s.pop();
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
