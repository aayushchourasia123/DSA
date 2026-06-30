/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode findInsertion(ListNode headA, ListNode headB,int diff){
            if(diff>0){
                while(diff--!=0){
                   headA=headA.next; 
                }
                
            }
            else{
                while(diff++!=0){
                   headB=headB.next; 
                }
            }
        while(headA!=null && headB!=null){
            if(headA==headB) return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA=0,countB=0;
        ListNode temp=headA;
        while(temp!=null){
            countA++;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            countB++;
            temp=temp.next;
        }
        return findInsertion(headA,headB,countA-countB);
    }
}