class myQueue {
    int f=-1;
    int r=-1;
    int size=0;
    int arr[];
    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        arr=new int[n];
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return size==0;
    }

    public boolean isFull() {
        // Check if queue is full
        return size==arr.length;
    }

    public void enqueue(int x) {
        // Enqueue
        if(isEmpty()){
            f=r=0;
            arr[0]=x;
        }
        else if(isFull()){
            return;
        }
        else{
            arr[++r]=x;
        }
        size++;
        return;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty()) return;
        else{
            f++;
        }
        size--;
        return;
    }

    public int getFront() {
        // Get front element
        if(isEmpty()) return -1;
        return arr[f];
    }

    public int getRear() {
        // Get last element
        if(isEmpty()) return -1;
        return arr[r];
    }
}
