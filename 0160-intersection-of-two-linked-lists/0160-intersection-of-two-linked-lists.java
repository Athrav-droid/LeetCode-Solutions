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
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {  
    //     ListNode temp = new ListNode();  //new referal temprory node 
    //     while(headA != null){  //check whether any one of the list is empty or not and then enters the while loop
    //         temp = headB; // store the head of another list in the temprory node
    //         while(temp!=null){  // till the temprory node is not empty check whether the first list is equal another list if yes then return that node ... if not then move to next node.
    //             if(headA == temp){
    //                 return temp;
    //             }else{
    //                 temp = temp.next;
    //             }
    //         }
    //         headA = headA.next; //for every node in first list so moving to next element 
    //     }
    //   return null;  // if both the lists are completely traversed then return null shows that there is no intersection point.
    // }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {  
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        a = headA;
        b = headB;
        //jb tk dono node unequal h tb check kro agr a = null tb usko b node se start krdo traverse krna and same agr b = null to usko a node se traverse krna start krdo and dono agr null nhi h to unko next node pe bhej do or last m kisi bhi ek node ko return krdo as a ans. 
        while(a!=b){
            if(a == null){
                a = headB;
            }else{
                a = a.next;
            }
            if(b == null){
                b = headA;
            }else{
                b = b.next;
            }
        }
        return a;
    }
}