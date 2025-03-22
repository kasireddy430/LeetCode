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
        // Base case: If the tree is empty, return null
        if (root == null) return null;
        
        // Connect the left child to the right child
        if (root.left != null) root.left.next = root.right;
        
        // Connect the right child to the left child of the next node, if it exists
        if (root.right != null && root.next != null) root.right.next = root.next.left;
        
        // Recursively connect the left and right subtrees
        connect(root.left);
        connect(root.right);
        
        // Return the root after connections are made
        return root;
    }
}