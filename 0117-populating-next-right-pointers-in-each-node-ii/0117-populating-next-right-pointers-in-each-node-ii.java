/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node current = root;  // Current node at the level
        Node dummy = new Node(0); // Dummy node to track the start of the next level
        Node prev = dummy; // Pointer to build the next level

        while (current != null) {
            // Process current level
            if (current.left != null) {
                prev.next = current.left;
                prev = prev.next;
            }
            if (current.right != null) {
                prev.next = current.right;
                prev = prev.next;
            }

            // Move to the next node in the current level
            current = current.next;

            // If we reach the end of the level, move to the next level
            if (current == null) {
                current = dummy.next; // Move to the first node of the next level
                dummy.next = null; // Reset the dummy node
                prev = dummy; // Reset prev pointer
            }
        }
        return root;
    }
}
