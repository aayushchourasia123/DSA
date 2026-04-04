class LRUCache {
    //tc=O(1) every function //sc=O(capacity)
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> hm=new HashMap<>();
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    void delete(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    void insertAfterHead(Node node){
        Node currAfterHead=head.next;
        head.next=node;
        node.next=currAfterHead;
        node.prev=head;
        currAfterHead.prev=node;
    }
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;

        Node node=hm.get(key);
        delete(node);
        insertAfterHead(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node=hm.get(key);
            node.val=value;
            delete(node);
            insertAfterHead(node);
        }
        else{
            if(hm.size()==cap){
                Node node=tail.prev;
                hm.remove(node.key);
                delete(node);
            }
            Node node=new Node(key,value);
            hm.put(key,node);
            insertAfterHead(node);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */