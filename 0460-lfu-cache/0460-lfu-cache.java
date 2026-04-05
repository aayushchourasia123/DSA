class DllNode{
    int key;
    int val;
    int frequency;
    DllNode prev;
    DllNode next;
    public DllNode(int key,int val){
        this.key=key;
        this.val=val;
        frequency=1;
    }
}

class Doublyll{
    int listSize;
    DllNode head;
    DllNode tail;
    public Doublyll(){
        listSize=0;
        head=new DllNode(0,0);
        tail=new DllNode(0,0);
        head.next=tail;
        tail.prev=head;
    }
    public void addNode(DllNode curNode){
        DllNode nextNode=head.next;
        curNode.next=nextNode;
        curNode.prev=head;
        head.next=curNode;
        nextNode.prev=curNode;
        listSize++;
    }
    public void removeNode(DllNode curNode){
        DllNode prevNode=curNode.prev;
        DllNode nextNode=curNode.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        listSize--;
    }
}
class LFUCache {
    int capacity;
    int curSize;
    int minFreq;
    Map<Integer,DllNode> cache;
    Map<Integer,Doublyll> freqMap;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        curSize=0;
        minFreq=0;
        cache=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        DllNode curNode=cache.get(key);
        if(curNode==null) return -1;

        updateNode(curNode);
        return curNode.val;
    }
    public void updateNode(DllNode curNode){
        int curFreq=curNode.frequency;
        Doublyll curList = freqMap.get(curFreq);;
        curList.removeNode(curNode);
        if(curFreq==minFreq && curList.listSize==0){
            minFreq++;
        }
        curNode.frequency++;
        Doublyll newList=freqMap.getOrDefault(curNode.frequency,new Doublyll());
        newList.addNode(curNode);
        freqMap.put(curNode.frequency,newList);
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(cache.containsKey(key)){
            DllNode curNode=cache.get(key);
            curNode.val=value;
            updateNode(curNode);
        }
        else{
            curSize++;
            if(curSize>capacity){
                Doublyll minFreqList=freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFreq=1;
            DllNode newNode=new DllNode(key,value);
            Doublyll curlist=freqMap.getOrDefault(1,new Doublyll());
            curlist.addNode(newNode);
            freqMap.put(1,curlist);
            cache.put(key,newNode);
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */