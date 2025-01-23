class Node{
    int key;
    int value;
    Node prev;
    Node next;

    //Constructor to initialize a node with given key and value
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    int cap; //Maximum capacity cache holds
    Map<Integer, Node> cache; //A hash map for fast look-ups for keys and nodes
    //Dummy node representing Least Recently Used(LRU) and Most Recently Used(MRU)
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        //Link both LRU and MRU to represent doubly linked list
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    //Helper method to remove the node from the list
    private void remove(Node cur){
        //Retrieve previous and the next nodes of the current node
        Node prev = cur.prev;
        Node nxt = cur.next;

        //Adjust pointers for bypassing the current node
        prev.next = nxt;
        nxt.prev = prev;
    }

    //Helper method to insert the node at the MRU end
    private void insert(Node cur){
        //Retrieve the most recently used node
        Node node = this.right.prev;

        //insert the current node at the MRU END by adjusting the pointers   
        node.next = cur;
        cur.prev = node;
        cur.next = this.right;
        this.right.prev = cur;
    }
    
    public int get(int key) {
        //Check for the key in hashmap
        if(cache.containsKey(key)){
            //If present retrieve it and add it to the MRU end
            Node newNode = cache.get(key);
            remove(newNode);
            insert(newNode);

            return newNode.value;
        }
        //If not, return -1
        return -1;
    }
    
    public void put(int key, int value) {
        //Check if the key-value pair is part of the hashmap
        if(cache.containsKey(key)){
            //If so remove it and later insert it to the MRU end
            remove(cache.get(key));
        }

        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);

        //Check if cache size exceeds the maximum capacity
        if(cache.size() > cap){
            //If so remove the least recently used node and also remove it from cache
            Node lru = this.left.next;

            remove(lru);
            cache.remove(lru.key);
        }
    }
}

//Time Complexity: O(1)
//Space Complexity: O(n). n is size of capacity

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */