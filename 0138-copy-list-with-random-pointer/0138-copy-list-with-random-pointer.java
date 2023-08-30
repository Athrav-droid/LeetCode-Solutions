/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head, next = null;
        // Step 1 :- Create Dummy Nodes after Each Original Node O1->D1->O2->D2->O3->D3->Null
        while(curr != null){
            next = curr.next;
            Node copy = new Node(curr.val);
            copy.next = next;
            curr.next = copy;
            curr = next;
        }
        Node temp = head;

        // Step 2 :- Make all random node point to correct randoms in Copy List
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }else{
                curr.next.random = null;
            }
            curr = curr.next.next;
        }

        // Step 3 :- Seprate Both Lists
        curr = head;
        Node copy = new Node(0);
        Node ans = copy;
        while(curr != null){
            next = curr.next.next;
            copy.next = curr.next;
            curr.next = next;
            curr = curr.next;
            copy = copy.next;
        }
        return ans.next;
    }
}