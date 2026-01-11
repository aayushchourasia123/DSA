/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // //tc=O(2n) //sc=O(n)
        // Stack<Integer> st=new Stack<>();
        // ListNode curr=head;
        // while(curr!=null){
        //     st.push(curr.val);
        //     curr=curr.next;
        // }
        // curr=head;
        // while(curr!=null && curr.val==st.pop()){
        //     curr=curr.next;
        // }
        // return curr==null;

        //tc=O(n) sc=O(1)
        if(head==null || head.next==null) return true;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=reverse(slow.next);
        ListNode first=head;
        ListNode second=newHead;
        while(second!=null){
            if(first.val!=second.val) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode save_next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=save_next;
        }
        return prev;
    }
}