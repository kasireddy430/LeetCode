/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node node = head;

        //Create new nodes and place them next to original nodes
        while(node != null){
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        node = head;
        //Setup random pointers for the cloned list
        while(node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //Seperate both lists and restore the original list
        node = head;
        Node clonedHead = node.next;
        //Preserve the cloned head to return at the end
        Node clone = clonedHead;
        while(clone.next != null){
            node.next = node.next.next;
            clone.next = clone.next.next;

            node = node.next;
            clone = clone.next;
        }

        node.next = null;
        clone.next = null;
        //return the head of cloned list
        return clonedHead;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)