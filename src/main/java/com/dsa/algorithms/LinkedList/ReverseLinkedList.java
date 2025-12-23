package com.dsa.algorithms.LinkedList;

import com.dsa.util.ListNode;

import static com.dsa.util.CommonMethods.generateLinkedList;
import static com.dsa.util.CommonMethods.printLinkedList;

public class ReverseLinkedList {

    public static ListNode reverseLinkedListInKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while (true) {
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i = 1 ; i < left ; i++) prev = prev.next;

        ListNode curr = prev.next;
        ListNode next;

        for(int i = 0 ; i < right - left ; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

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
        ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        printLinkedList(head);
        head = reverseBetween(head, 1, 4);
        printLinkedList(head);
    }
}
