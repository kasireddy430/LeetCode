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
        if(lists.length == 0){
            return null;
        }

        //Use divide and Conquer to merge the sorted lists within range: (0 to lists.length - 1)
        return divide(lists, 0, lists.length - 1);
    } 

    //Helper method to recursively divide the lists
    private ListNode divide(ListNode[] lists, int left, int right){
        //Check if the input lists are valid or not
        if(left > right){
            return null;
        }

        //if the input has only one list, return it
        if(left == right){
            return lists[left];
        }

        int mid = left + (right - left)/2;
        //recursively divide the lists into two halves
        ListNode firstHalf = divide(lists, left, mid);
        ListNode secondHalf = divide(lists, mid + 1, right);

        //Conquer step: use conquer step to merge the lists
        return conquer(firstHalf, secondHalf);
    }

    //Helper method to merge two lists
    private ListNode conquer(ListNode list1, ListNode list2){
        //Create a dummy node to simplify merging of the lists
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        //Iterate through both the lists
        while(list1 != null && list2 != null){
            //Check if the value in list1 is smaller
            if(list1.val <= list2.val){
                //if so, add it to the merged list
                node.next = list1;
                list1 = list1.next;
            } else {
                //if not add list2 to the merged list
                node.next = list2;
                list2 = list2.next;
            }
            //Move the pointer in merged list
            node = node.next;
        }

        //Check if any of the lists still holds the nodes
        if(list1 != null){
            node.next = list1;
        } else{
            node.next = list2;
        }

        //return the head of sorted merged list
        return dummy.next;
    }
}

//Time Complexity: O(n * log k)
//Space Complexity: O(log k)
// Where n is total number of nodes the entire list and k is number of lists in input array
