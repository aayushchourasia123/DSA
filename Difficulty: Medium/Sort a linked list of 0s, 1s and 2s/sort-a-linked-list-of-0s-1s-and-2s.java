/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node temp=head;
        int count_0=0;
        int count_1=0;
        int count_2=0;
        while(temp!=null){
            if(temp.data==0){
                count_0++;
            }
            else if(temp.data==1){
                count_1++;
            }
            else{
                count_2++;
            }
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(count_0!=0){
                temp.data=0;
                count_0--;
            }
            else if(count_1!=0){
                temp.data=1;
                count_1--;
            }
            else{
                temp.data=2;
                count_2--;
            }
            temp=temp.next;
        }
        return head;
    }
}