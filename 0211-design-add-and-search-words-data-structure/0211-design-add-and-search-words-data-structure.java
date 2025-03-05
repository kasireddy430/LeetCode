class TrieNode{
    TrieNode[] children = new TrieNode[26];//Array to store children nodes a-z
    boolean endWith = false;//flag to track enf of the word
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;//start from root node

        for(char c : word.toCharArray()){
            int index = c - 'a';//calculate index of current character

            //if there is node for current index, create a trieNode
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];//Move to next node
        }
        current.endWith = true;//after exiting the loop, mark the end of the word
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);//recursively search the word
    }

    private boolean searchHelper(String word, int index, TrieNode root){
        if(root == null) return false;//if there aren't any nodes, then the word isn't available

        //If index reaches end of the word length, check if it is the end
        if(index == word.length()) return root.endWith;

        char c = word.charAt(index);//calculate index of character

        if(c != '.'){//if character isn't a wild card, recursively search for word
            int ind = c - 'a';
            return searchHelper(word, index + 1, root.children[ind]);
        } else{//If it is a wild card, check for all 26 children nodes to see if it is valid or not
            for(TrieNode child : root.children){
                if(child != null && searchHelper(word, index + 1, child)){
                    return true;
                }
            }
        }
        return false;
    }
}

//Time Complexity: O(n) for both functions where n is length of word
//Space Complexity: O(n) for search and O(t) for add, where t is no.of characters

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */