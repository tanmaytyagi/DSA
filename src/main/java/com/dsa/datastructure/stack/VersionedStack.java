package com.dsa.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class VersionedStack<T> {
    private record Node<T>(T value, Node<T> next) {}
    private final List<Node<T>> versions = new ArrayList<>();

    public VersionedStack() {
        versions.add(null); // version 0 = empty stack
    }

    public int push(T value) {
        Node<T> top = versions.getLast();
        Node<T> node = new Node<>(value, top);
        versions.add(node);
        return versions.size() - 1;
    }

    public int pop() {
        Node<T> node = versions.getLast();
        if(node == null) {
            throw new IllegalStateException("Stack is empty");
        }
        versions.add(node.next);
        return versions.size() - 1;
    }

    public T peek() {
        Node<T> lastNode = versions.getLast();
        if(lastNode == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return lastNode.value;
    }

    public int latestVersion() {
        return versions.size() - 1;
    }

    public void printStackAtVersion(int version) {
        if(version < 0 || version > latestVersion()) {
            throw new IllegalArgumentException("Invalid version");
        }
        Node<T> node = versions.get(version);
        while(node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    public void printStack() {
        printStackAtVersion(latestVersion());
    }

    public static void main(String[] args) {
        VersionedStack<Integer> s = new VersionedStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        s.printStack();
        System.out.println(s.peek());
    }
}
