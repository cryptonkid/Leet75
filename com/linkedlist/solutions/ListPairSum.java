package com.linkedlist.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2130. Maximum Twin Sum of a Linked List
 * It teaches how reverse from middle
 * Also other solutions include using Arrays and Stack.
 */
public class ListPairSum {
    /**
     * TC: O(n)
     * SC : O(1)
     * @param head ListNode
     * @return int
     */
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // Go to middle of the linked list.
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //Reverse second half of the linked list:
        //End of it "prev" will point to the end of the current linked list.
        ListNode prev = null;
        ListNode current;
        while(slow != null){
            current = slow.next;
            slow.next = prev;
            prev = slow;
            slow = current;
        }


        ListNode start = head;
        int maxSum = 0;
//        Note : replacing prev with start will fail see the state of
//        head, prev , start by below output after reversing the half list.
//        head:[5,4,2]
//
//        slow:null
//        fast:null
//        prev:[1,2]
//        start:[5,4,2]
        while(prev != null){
            maxSum = Math.max(maxSum, (start.val + prev.val));
            prev = prev.next;
            start = start.next;
        }
        return maxSum;
    }
    /**
     * Other Approches :
     * Using ArrayList and Stack
     * TC: O(n)
     * SC : O(n)
     */
    public int pairSumUsingArrayList(ListNode head) {
        ListNode current = head;
        List<Integer> values = new ArrayList<>();

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int i = 0, j = values.size() - 1;
        int maximumSum = 0;
        while (i < j) {
            maximumSum = Math.max(maximumSum, values.get(i) + values.get(j));
            i++;
            j--;
        }

        return maximumSum;
    }
    public int pairSumUsingStack(ListNode head) {
        ListNode current = head;
        Stack<Integer> st = new Stack<>();

        while (current != null) {
            st.push(current.val);
            current = current.next;
        }

        current = head;
        int size = st.size(), count = 1;
        int maximumSum = 0;
        while (count <= size / 2) {
            maximumSum = Math.max(maximumSum, current.val + st.peek());
            current = current.next;
            st.pop();
            count++;
        }

        return maximumSum;
    }


}
