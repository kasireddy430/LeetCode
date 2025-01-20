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
    public ListNode reorderList(ListNode head) {
        //Initialize pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        //Iterate through the list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverse(slow);
        //Preserve the head of the list to return at the end
        ListNode firstHalfHead = head;

        //Perform list re-ordering
        while(firstHalfHead != null && secondHalfHead != null){
            //Store next nodes of both the halves
            ListNode temp1 = firstHalfHead.next;
            ListNode temp2 = secondHalfHead.next;

            //Adjust the pointers
            firstHalfHead.next = secondHalfHead;
            secondHalfHead.next = temp1;

            //Move current nodes in both the lists to their next nodes respectively
            firstHalfHead = temp1;
            secondHalfHead = temp2;
        }

        //Ensure re-ordered list terminates properly
        if(firstHalfHead != null){
            firstHalfHead.next = null;
        }

        //Return the head of re-ordered list
        return head;
    }

    private ListNode reverse(ListNode cur){
        //Create a node which will be head of reversed list
        ListNode prev = null;

        //Iterate through the list
        while(cur != null){
            //store next node
            ListNode next = cur.next;
            //point the current node to the previous node
            cur.next = prev;
            prev = cur; //Move previous node to current node
            cur = next; //Move current node to next node
        }
        return prev;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)