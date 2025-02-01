/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }

    //Helper method to covert TreeNode -> String
    private void dfsSerialize(TreeNode root, List<String> result){
        // if a node is null, add "#" as null marker
        if(root == null){
            result.add("#");
            return;
        }

        //Add the current node to arrayList
        result.add(String.valueOf(root.val));

        //Recursively process the treeNode's
        dfsSerialize(root.left, result);
        dfsSerialize(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        int[] i = {0};//Mutable index for recursion
        return dfsDeserialize(val, i);
    }

    private TreeNode dfsDeserialize(String[] val, int[] i){
        //Convert "#" marker's back to null
        if(val[i[0]].equals("#")){
            i[0]++;
            return null;
        }

        //Construct new Tree node for the current value
        TreeNode root = new TreeNode(Integer.parseInt(val[i[0]]));
        i[0]++;
        //recursively contruct left and right subtree's
        root.left = dfsDeserialize(val, i);
        root.right = dfsDeserialize(val, i);

        return root;
    }
}

//Time Complexity: O(n)
//Space complexity: O(n)

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));