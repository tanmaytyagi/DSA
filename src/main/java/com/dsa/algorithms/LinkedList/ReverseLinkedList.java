package com.dsa.algorithms.LinkedList;

import com.dsa.util.ListNode;

import static com.dsa.util.CommonMethods.generateLinkedList;
import static com.dsa.util.CommonMethods.printLinkedList;

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

    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        printLinkedList(head);
        head = reverse(head);
        printLinkedList(head);
    }
}
