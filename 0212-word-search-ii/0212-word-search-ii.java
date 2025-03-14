class Solution {
    class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean ends = false;
        String word = null; // Store word at the end node
    }

    class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }
        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.ends = true;
            curr.word = word; // Store full word at the last node
        }
    }

    public void dfs(char[][] board, int i, int j, Node node, Set<String> found) {
        int m = board.length, n = board[0].length;

        // Boundary Check
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#' || !node.children.containsKey(board[i][j])) {
            return;
        }

        char c = board[i][j];
        Node nextNode = node.children.get(c);

        // If the word is found, add it to the result
        if (nextNode.ends) {
            found.add(nextNode.word);
            nextNode.ends = false; // Prevent duplicate work
        }

        // Mark as visited
        board[i][j] = '#';

        // Explore 4 directions
        dfs(board, i + 1, j, nextNode, found);
        dfs(board, i - 1, j, nextNode, found);
        dfs(board, i, j + 1, nextNode, found);
        dfs(board, i, j - 1, nextNode, found);

        // Restore original value
        board[i][j] = c;

        // **Optimization:** If no words remain in this Trie branch, remove it
        if (nextNode.children.isEmpty()) {
            node.children.remove(c);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        Node root = trie.root;
        Set<String> found = new HashSet<>();
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, found);
            }
        }

        return new ArrayList<>(found);
    }
}