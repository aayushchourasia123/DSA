// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class
class myStack {
    Node head;
    int size;
    public myStack() {
        // Initialize your data members
        head=null;
        size=0;
        
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return size==0;
    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        Node temp=new Node(x);
        temp.next=head;
        head=temp;
        size++;
        return;
    }

    public void pop() {
        // Removes the front element of the stack.
        if(head==null){
            return;
        }
        head=head.next;
        size--;
        return;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if(head==null){
            return -1;
        }
        
        return head.data;
    }
    

    public int size() {
        // Returns the current size of the stack.
        return size;
    }
}
