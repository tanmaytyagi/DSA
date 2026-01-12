package com.dsa.algorithms.LinkedList;

import com.dsa.algorithms.LinkedList.LinkedListUtil.ListNode;
import static com.dsa.algorithms.LinkedList.LinkedListUtil.generateLinkedList;
import static com.dsa.algorithms.LinkedList.LinkedListUtil.printLinkedList;

import static com.dsa.algorithms.LinkedList.CycleDetectionInLinkedList.hasCycle;
import static com.dsa.algorithms.LinkedList.FindStartingPointOfCycle.findStartingPointOfCycle;


public class RemoveCycleInLinkedList {

    public static ListNode removeCycle(ListNode head) {
        if (!hasCycle(head)) return head;
        ListNode start = findStartingPointOfCycle(head);
        ListNode iter = start;
        while (iter.next != start) {
            iter = iter.next;
        }
        iter.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode left = head.next;
        ListNode right = head.next.next.next.next.next;
        right.next = left;
        printLinkedList(head);
        printLinkedList(removeCycle(head));
    }
}
