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
    public ListNode reverseKGroup(ListNode head, int k) {
        //Create a dummy node to simplify reversing nodes in k-groups
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        //Iterate untill all the nodes are reversed in k-groups
        while(true){
            //retrieve kth node
            ListNode kth = getkth(groupPrev, k);

            //Check if kth node is null. If so, exit the loop
            if(kth == null){
                break;
            }

            //Retrieve the first node from the next group
            ListNode groupNext = kth.next;
            //Retrieve the first node n current group and preserve the first node in next group
            ListNode cur = groupPrev.next;
            ListNode prev = groupNext;

            //Iterate until current pointer reaches the first node in next group and reverse all the nodes in current group
            while(cur != groupNext){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next; 
            }

            //Preserve the next node of the groupPrev
            ListNode tmp = groupPrev.next;
            //Adjust the pointers
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        //Return the head of the new list
        return dummy.next;
    }

    private ListNode getkth(ListNode cur, int k){
        //Iterate until if either current pointer reaches null or k reaches 0.
        while(cur != null && k > 0){
            cur  = cur.next;
            k--;
        }

        //return kth node and return null if no.of nodes is fewere than k
        return cur;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)