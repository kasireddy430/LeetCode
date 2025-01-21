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
    public ListNode mergeKLists(ListNode[] lists) {
        //Check if the input array is empty
        if(lists.length == 0 || lists == null){
            // If so, return null
            return null;
        }

        //If not, use divide and conquer to merger the lists with range: 0 to lists.length - 1
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int left, int right){
        //Check if the lists are valid using boundaries
        if(left>right){
            return null;
        }

        //Check if it has only one list. if so return it
        if(left == right){
            return lists[left];
        }

        int mid = left + (right - left)/2;
        //Recursively divide the list into two halves
        ListNode leftHalf = divide(lists, left, mid);
        ListNode rightHalf = divide(lists, mid + 1, right);

        //Conquer Step: use conquer step to merge both the halves and return a merged list
        return conquer(leftHalf, rightHalf);
    }

    private ListNode conquer(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        } 

        if(l1 != null){
            node.next = l1;
        } else {
            node.next = l2;
        }

        return dummy.next;
    } 
}