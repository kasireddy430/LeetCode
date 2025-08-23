class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        TreeNode cur = root;

        while(cur != null){
            if(cur.left == null){
                //Visit current node
                if(prev != null && prev.val > cur.val){
                    if(first == null) first = prev;
                    second = cur;
                }
                
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode predecessor = cur.left;

                while(predecessor.right != null && predecessor.right != cur){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                } else{
                    predecessor.right = null;
                    //Visit current Node
                    if(prev != null && prev.val > cur.val){
                        if(first == null) first = prev;
                        second = cur;
                    }
                    
                    prev = cur;
                    cur = cur.right;
                }
            }
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

//TC: O(n)
//SC: O(1)
