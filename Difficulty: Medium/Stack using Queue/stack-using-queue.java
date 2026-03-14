class myStack {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        // Inserts an element x at the top of the stack
        q.add(x);
        for(int i=1;i<q.size();i++){
            q.add(q.remove());
        }
        return;
    }

    void pop() {
        // Removes an element from the top of the stack
        if(!q.isEmpty()){
            q.remove();
            return;
        }
        
    }

    int top() {
        // Returns the top element of the stack
        // If stack is empty, return -1
        if(q.isEmpty()){
            return -1;
        }
        return q.peek();
    }

    int size() {
        // Returns the current size of the stack1
        return q.size();
    }
}
