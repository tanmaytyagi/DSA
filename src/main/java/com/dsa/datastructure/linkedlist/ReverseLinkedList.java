package com.dsa.datastructure.linkedlist;

import com.dsa.util.CommonMethods;
import com.dsa.util.ListNode;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = CommonMethods.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);
    }
}
