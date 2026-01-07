package com.dsa.algorithms.LinkedList;

import com.dsa.util.LinkedListUtil.ListNode;
import static com.dsa.util.LinkedListUtil.generateLinkedList;

public class FindStartingPointOfCycle {

    public static ListNode findStartingPointOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode left = head.next.next.next;
        ListNode right = head.next.next.next.next.next.next;
        right.next = left;
        System.out.println(findStartingPointOfCycle(head).val);
    }
}
