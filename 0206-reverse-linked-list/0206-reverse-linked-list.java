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
    public ListNode reverseList(ListNode head) {
        //Initilize a pointer which will be the head of reversed list
        ListNode prev = null;

        while(head != null){
            //store the next node
            ListNode next = head.next;
            //point current node to the previous node
            head.next = prev;
            prev = head; //Move the prev pointer to current node
            head = next; //Move the current node to the next node
        }
        return prev;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)