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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstNode = null;
        ListNode secondNode = null;
        int length = 0;
        ListNode curr = head;

        while(curr != null){
            length++;
            if(secondNode != null){
                secondNode = secondNode.next;
            }

            if(length == k){
                firstNode = curr;
                secondNode = head;
            }
            curr = curr.next;
        }

        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;

        return head;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)