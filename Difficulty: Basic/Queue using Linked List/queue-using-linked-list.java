// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {
    Node front,rear;
    int size;
    public myQueue() {
        // Initialize your data members
        front=null;
        rear=null;
        size=0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return size==0;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        Node temp=new Node(x);
        if(isEmpty()){
            front=rear=temp;
            
        }
        else{
            rear.next=temp;
            rear=temp;
        }
        size++;
        return;
    }

    public void dequeue() {
        // Removes the front element of the queue
        front=front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if(front==null) return -1;
        return front.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return size;
    }
}
