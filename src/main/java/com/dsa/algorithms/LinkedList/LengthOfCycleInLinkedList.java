package com.dsa.algorithms.LinkedList;

import com.dsa.util.ListNode;

import static com.dsa.algorithms.LinkedList.CycleDetectionInLinkedList.hasCycle;
import static com.dsa.algorithms.LinkedList.FindStartingPointOfCycle.findStartingPointOfCycle;
import static com.dsa.util.CommonMethods.generateLinkedList;

public class LengthOfCycleInLinkedList {

    public static int lengthOfCycle(ListNode head) {
        if (head == null || head.next == null) return 0;
        if (!hasCycle(head)) return 0;

        ListNode start = findStartingPointOfCycle(head);
        ListNode iter = start;
        int len = 1;

        while(iter.next != start) {
            iter = iter.next;
            len++;
        }

        return len;
    }

    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode left = head.next.next;
        ListNode right = head.next.next.next.next.next.next;
        right.next = left;
        System.out.println(lengthOfCycle(head));
    }
}
