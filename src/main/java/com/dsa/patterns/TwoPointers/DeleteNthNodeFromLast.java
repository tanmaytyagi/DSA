package com.dsa.patterns.TwoPointers;

/**
 * Given the head of a singly linked list and an integer n,
 * remove the nth node from the end of the list and return the head of the modified list.
 */
public class DeleteNthNodeFromLast {
     static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

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

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        head = removeNthLastNode(head, 5);
        printList(head);
    }
}
