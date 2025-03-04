//TrieNode class represents each node in trie
class TrieNode{
    TrieNode[] children = new TrieNode[26]; //Array to store 26 characters a-z
    boolean endWith = false;//flag tracking end of the word
}

class Trie {
    private TrieNode root;

    //Constructor to initilize trie object
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        //start from root node
        TrieNode current = root;

        for(char c : word.toCharArray()){
            int index = c - 'a';//Calculate index of the character

            //If there is no node for current character, create one
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            //Move to next node
            current = current.children[index];
        }
        //After exit the loop, it is end of the word. update endWith flag
        current.endWith = true;
    }
    
    public boolean search(String word) {
        //start from root node
        TrieNode current = root;

        //Iterate over each character in input word
        for(char c : word.toCharArray()){
            int index = c - 'a';

            //Check if there is no node for current character
            if(current.children[index] == null){
                return false;//If so return false
            }
            current = current.children[index];//Move to next node
        }

        // If the last node marks the end of a word, return true, otherwise return false
        return current.endWith;     
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;//start from root node

        //Iterate over each character
        for(char c : prefix.toCharArray()){
            int index = c - 'a';//calculate index

            //If there is no node for current character return false
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        //return true if there is a word with input prefix
        return true;             
    }
}

//Time Complexity: O(m). m reprents length of input string
//Space Complexity: O(n). n represents number of characters

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */