/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Node h=head;
        
        while(h.data<tail.data){
            
            if(h.data+tail.data==target){
                ans.add(new ArrayList<>(Arrays.asList(h.data, tail.data)));
                h=h.next;
                tail=tail.prev;
            }
            else if(h.data+tail.data>target) tail=tail.prev;
            
            else h=h.next;
        }
        return ans;
    }
}
