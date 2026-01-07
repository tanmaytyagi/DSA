package com.dsa.util;

public class LinkedListUtil {

    // ================== IMPL METHODS FOR LINKED LIST ==================

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode generateLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("Used rarely in DSA rounds");
    }
}
