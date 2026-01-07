package com.dsa.algorithms.Arrays.TwoPointers;

import com.dsa.util.LinkedListUtil.ListNode;

import static com.dsa.util.LinkedListUtil.generateLinkedList;
import static com.dsa.util.LinkedListUtil.printLinkedList;

/**
 * Given the head of a singly linked list and an integer n,
 * remove the nth node from the end of the list and return the head of the modified list.
 */
public class DeleteNthNodeFromLast {

    private static ListNode removeNthLastNode(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast =  head;
        ListNode slow = head;
        ListNode prev = null;

        for(int i = 0 ; i < n ; i++) fast = fast.next;

        while(fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev == null) return head.next;

        prev.next = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        printLinkedList(head);
        head = removeNthLastNode(head, 3);
        printLinkedList(head);
    }
}
