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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        int reverseRange = right - left;

        while(left - 1 != 0){
            slow = slow.next;
            left--;
        }

        ListNode cur = slow.next;
        ListNode tmp = cur;

        ListNode prev = null;

        for(int i = 0; i <= reverseRange; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        slow.next = prev;
        tmp.next = cur;

        return dummy.next;
    }
}

//TC: O(n)
//SC: O(1)