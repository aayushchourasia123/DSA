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
    public ListNode findIntersection(ListNode headA,ListNode headB,int diff){
        ListNode tempA=headA;
        ListNode tempB=headB;
        if(diff>0){
            while(diff--!=0) tempA=tempA.next;
        }
        else {
            while(diff++!=0) tempB=tempB.next;
        }

        while(tempA!=null){
            if(tempA==tempB) return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //tc=O(n+m) sc=O(1)
        ListNode tempA=headA;
        ListNode tempB=headB;

        int countA=0;
        while(tempA!=null){
            countA++;
            tempA=tempA.next;
        }
        int countB=0;
        while(tempB!=null){
            countB++;
            tempB=tempB.next;
        }
        return findIntersection(headA,headB,countA-countB);
    }
}