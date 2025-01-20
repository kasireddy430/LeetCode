/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Create dummy node to simplify removing the nth node from end
        ListNode dummy = new ListNode(0, head);
        //Initialize pointers, one at dummy and the other at the head
        ListNode slow = dummy;
        ListNode fast = head;

        //Move the fast pointer by n places
        while(n>0){
            fast = fast.next;
            n--;
        }

        //Move slow and fast pointers by one step
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        //Adjust the pointer by bypassing the nth node in the list
        slow.next = slow.next.next;

        return dummy.next;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)