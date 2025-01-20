/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Initilize pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        //Iterate through the list
        while(fast != null && fast.next != null){
            //move slow pointer by one step
            slow = slow.next;
            fast = fast.next.next;

            //Check if both the pointers meet
            if(slow == fast){
                //If so, return true indicating the cycle existence
                return true;
            }
        }
        return false;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)