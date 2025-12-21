package com.dsa.patterns.FastAndSlowPointers;

import com.dsa.util.CommonMethods;
import com.dsa.util.ListNode;

public class LinkedListCycleDetection {

    public static boolean hasCycle(ListNode head) {
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
        ListNode head = CommonMethods.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode right = head;
        right = right.next.next.next.next;
        right.next = head;

        System.out.println(hasCycle(head));
    }
}
