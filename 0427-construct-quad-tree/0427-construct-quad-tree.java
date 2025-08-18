/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private Node solve(int[][] grid, int i, int j, int length){
        if(length == 1){
            return new Node(grid[i][j] == 1, true);
        }

        int size = length/2;
        Node topLeft = solve(grid, i, j, size);
        Node topRight = solve(grid, i, j + size, size);
        Node bottomLeft = solve(grid, i + size, j, size);
        Node bottomRight = solve(grid, i + size, j + size, size);

        if(topLeft.val == topRight.val && topRight.val == bottomLeft.val &&
        bottomLeft.val == bottomRight.val && topLeft.isLeaf && topRight.isLeaf &&
        bottomLeft.isLeaf && bottomRight.isLeaf){
            return new Node(topLeft.val, true);
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

//TC: O(n ^ 2)
//SC: O(log n) (O(n ^ 2) if output space is considered).