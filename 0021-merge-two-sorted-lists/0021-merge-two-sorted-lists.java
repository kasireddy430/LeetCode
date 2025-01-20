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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Create a dummy node to simplify merging of two sorted lists
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        //Iterate through both the lists
        while(list1 != null && list2 != null){
            //Check if the value in list1 is smaller compared to list2
            if(list1.val <= list2.val){
                //If so point smaller node to the merge list
                node.next = list1;
                //move current node in list1 to next node
                list1 = list1.next;
            } else{
                node.next = list2;
                list2 = list2.next;
            }
            //Move the current node in the merge list
            node = node.next;
        }

        //Check if any of the lists still holds the lits. If so append them to the end of the merged list
        if(list1 != null){
            node.next = list1;
        } else{
            node.next = list2;
        }

        // return the head of the merged list
        return dummy.next;
    }
}

//Time Complexity: O(m + n). m is no.of nodes in list1 and n is no.of node is list2
//Space Complexity: O(1)