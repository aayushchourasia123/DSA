class myStack {
    int arr[];
    int top;
    int cap;
    public myStack(int n) {
        // Define Data Structures
        arr=new int[n];
        top=-1;
        
        cap=n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top==-1;
    }

    public boolean isFull() {
        // check if the stack is full
        return top==cap-1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(isFull()){
            //System.out.println("stack overflow");
            return;
        }
        top=top+1;
        arr[top]=x;
    }

    public void pop() {
        // Removes an element from the top of the stack
         if (isEmpty()) {
            //System.out.println("Stack Underflow");
            return;
        }
        top--;
    }

    public int peek() {
        // Returns the top element of the stack
        if (isEmpty()) {
            //System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }
}