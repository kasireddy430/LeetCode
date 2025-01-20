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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Create a dummy node to simplify the result list
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        //Initialize a variable to handle values greater than 9
        int carry = 0;

        //Iterate over both the lists
        while(l1 != null || l2 != null || carry != 0){
            //calculate the current node's values from both the lists
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;


            int result = v1 + v2 + carry;
            //Update the value to use it next iteration
            carry = result/10;
            //calculate the value that needs to be added to the list
            result = result%10;

            node.next = new ListNode(result);
            //Move pointer to next node
            node = node.next;

            //Move from curent node's to next node's in both the lists 
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        //return the head of new list
        return dummy.next;
    }
}

//Time Complexity : O(m + n). 
// m: no.of nodes in l1
// n: no.of nodes in l2  
//Space Complexity: O(1)