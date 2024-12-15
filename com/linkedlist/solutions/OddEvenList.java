package com.linkedlist.solutions;

/**
 * 328. Odd Even Linked List
 * Teaches traversing alternate nodes
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null ){
            return head;
        }

        ListNode oddP = head;
        ListNode evenP = head.next;
        //Note we need an even head for starting point.
        ListNode evenHead = evenP;
        while(evenP != null && evenP.next != null ){ // important 2nd Condition: "even.next != null"
            oddP.next = evenP.next;
            oddP = oddP.next; // odd pointer moved.
            evenP.next = oddP.next;
            evenP = evenP.next;//Even pointer moved
        }
        oddP.next = evenHead;
        return head;
    }
}
