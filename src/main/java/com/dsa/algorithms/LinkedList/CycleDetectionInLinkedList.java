package com.dsa.algorithms.LinkedList;

import com.dsa.algorithms.LinkedList.LinkedListUtil.ListNode;
import static com.dsa.algorithms.LinkedList.LinkedListUtil.generateLinkedList;

public class CycleDetectionInLinkedList {

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode left = head.next.next;
        ListNode right = head.next.next.next.next.next.next;
        right.next = left;
        System.out.println(hasCycle(head));
    }
}
