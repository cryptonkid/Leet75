package com.linkedlist.solutions;

/**
 * 2095. Delete the Middle Node of a Linked List
 * Teaches the concept of slow and fast Pointer.
 */
public class DeleteMiddleOfList {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: return nullptr if there is only one node.
        if (head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Let 'fast' move forward by 2 nodes, 'slow' move forward by 1 node each step
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //When fast reachs end,, remove the next node of 'slow' and return 'head'.
        slow.next = slow.next.next;
        return head;

    }
}
