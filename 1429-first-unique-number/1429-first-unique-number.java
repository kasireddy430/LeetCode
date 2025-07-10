class Node{
    int val;
    boolean isUnique;
    Node prev;
    Node next;

    Node(int val){
        this.val = val;
        isUnique = true;
        this.prev = null;
        this.next = null;
    }
}

class FirstUnique {
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;

        for(int num : nums){
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if(head.next != tail){
            return head.next.val;
        }
        return -1;
    }

    private void addList(Node node){
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void removeList(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void add(int value) {
        if(!map.containsKey(value)){
            Node node = new Node(value);
            addList(node);
            map.put(value, node);
        } else {
            Node cur = map.get(value);
            if(cur.isUnique){
                removeList(cur);
            }
            cur.isUnique = false;
        }
    }
}