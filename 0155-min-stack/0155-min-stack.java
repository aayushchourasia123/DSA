// //tc=O(1)
// //sc=O(2*n)
// class MinStack {
//     Stack<int[]> st;
//     public MinStack() {
//         st=new Stack<>();
//     }
    
//     public void push(int val) {
//        if(st.isEmpty()){
//         st.push(new int[]{val,val});
//        }
//        else{
//         st.push(new int[]{val,Math.min(val,st.peek()[1])});
//        }
//     }
    
//     public void pop() {
//         st.pop();
//     }
    
//     public int top() {
//         return st.peek()[0];
//     }
    
//     public int getMin() {
//         return st.peek()[1];
//     }
// }

//tc=O(1) sc=O(1)
class MinStack {
    Stack<Long> st;
    long minval;
    public MinStack() {
        st=new Stack<>();
        minval=0;
    }
    
    public void push(int val) {
        long v=val;
       if(st.isEmpty()){
        minval=v;
        st.push(v);
        
       }

       else if(v<minval){
        st.push(2*v -minval);
        minval=v;
       }
       else{
        st.push(v);
       }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        if(st.peek()<minval){
            minval=2*minval - st.peek();
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long top=st.peek();
        if(top<minval){
            return (int)minval;
        }
        return (int)top;
    }
    
    public int getMin() {
        return (int)minval;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */