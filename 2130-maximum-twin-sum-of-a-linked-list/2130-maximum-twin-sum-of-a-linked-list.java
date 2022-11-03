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
    public int pairSum(ListNode head) {
//         ListNode temp = head;
//         int length=0;
//         while(temp!=null){
//             temp= temp.next;
//             length++;
//         }
//         temp = head;
//         int maxi = 0;
//         for(int i=0;i<length/2;i++){
//             int sum=0;
//             sum += getNode(head,i);
//             sum += getNode(head,length-i-1);
//             if(sum>maxi){
//                 maxi = sum;
//             }
//         }
//         return maxi;
//     }
//     public int getNode(ListNode head, int i){
//         while(i!=0){
//             head=head.next;
//             i--;
//         }
//         return head.val;
//     }
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int i=0;
        int j=arr.size()-1;
        int maxi = 0;
        while(i<j){
            int sum = 0;
            sum += arr.get(i) + arr.get(j);
            if(sum>maxi){
                maxi = sum;
            }
            i++; j--;
        }
        return maxi;
    }
}