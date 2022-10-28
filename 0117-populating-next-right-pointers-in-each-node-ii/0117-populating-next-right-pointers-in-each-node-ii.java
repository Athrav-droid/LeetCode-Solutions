/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    //Take Help of First Part and then solve it ... only one word change from left to right if 3rd if condition
class Solution {
    public Node connect(Node root) {
        if(root==null || (root.left==null&&root.right==null)){  //if no root or no left right then return root
            return root;
        }
        //if root's left not null then check for root's right. if there is root's right then point left to right directly else check for the next node and call the function which will give the next possible node for connection.
        if(root.left!=null){  
            if(root.right!=null){
                root.left.next = root.right;
            }else{
                if(root.next!=null){
                    root.left.next = adjacentRightNode(root.next);
                }
            }
        }
        //if root's right not null then check for root's next. if there is root's next then exit the condition and went to recursive calls but if root's next exists then call the function which will give the next possible node for connection.
        if(root.right!=null){
            if(root.next!=null){
                    root.right.next = adjacentRightNode(root.next);
                }
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    public Node adjacentRightNode(Node root) {
        Node temp = root;
        while(temp != null) { //if no left and right then move to next node and check if it is not null and while loop continues
            if(temp.left == null && temp.right == null) {
                temp = temp.next;
            }
            else{
                if(temp.left != null) return temp.left; //else return left if exists
                if(temp.right != null) return temp.right;//else return right if exists
            }
        }
        return null; //if nothing exists then directly return null.
    }
}