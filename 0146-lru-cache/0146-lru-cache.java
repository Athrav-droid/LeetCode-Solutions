class LRUCache {
    class Node {
        int key = -1;
        int value = -1;
        Node prev = null;
        Node next = null;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        void clear(){
            this.prev = null;
            this.next = null;
        }
    }

    class DoublyLinkedList {
        Node head = null;
        Node tail = null;

        void add(Node newNode){
            if(head == null){
                head = newNode;
                tail = head;
            }else{
                tail.next = newNode;
                tail.next.prev = tail;
                tail = tail.next;
            }
        }

        void remove(Node node){
            if(node == head){
                // deleting head node
                this.remove();
                node.clear();
                return;
            }
            if(node == tail){
                tail = tail.prev;
                tail.next = null;
                node.clear();
                return;
            }
            if(node.next != null){
                node.next.prev = node.prev;
            }
            if(node.prev != null){
                node.prev.next = node.next;
            }
            node.clear();
        }

        int remove(){
            int value = head.key;
            if(head.next != null){
                head.next.prev = null;
            }
            head = head.next;
            return value;
        }
    }

    Node[] cache = new Node[10001];
    DoublyLinkedList LRU = new DoublyLinkedList();
    int currSize = 0;
    int maxSize = 3000;

    public LRUCache(int capacity) {
        maxSize = capacity;
    }
    
    public int get(int key) {
        if(cache[key] != null){
            LRU.remove(cache[key]);
            LRU.add(cache[key]);
            return cache[key].value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache[key] != null){
            LRU.remove(cache[key]);
            LRU.add(cache[key]);
            cache[key].value = value;
        }else if(currSize == maxSize){
            int least_recently_used = LRU.remove();
            cache[least_recently_used] = null;
            cache[key] = new Node(key, value);
            LRU.add(cache[key]);
        }else{
            cache[key] = new Node(key, value);
            LRU.add(cache[key]);
            currSize++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//  class LRUCache {
//     Map<Integer, Integer> map = new HashMap<>();
//     Map<Integer, Integer> lru = new HashMap<>();
//     int cap;
//     int last;
//     public LRUCache(int capacity) {
//         cap = capacity;
//         last = 0;
//     }
    
//     public int get(int key) {
//         if(map.containsKey(key)){
//             lru.put(key, last++);
//             return map.get(key);
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         if(cap > 0){
//             map.put(key, value);
//             lru.put(key, last);
//             cap--;
//         }else{
//             if(lru.containsKey(key)){
//                 lru.put(key, last);
//                 map.put(key, value);
//             }else{
//                 int minKey = Integer.MAX_VALUE;
//                 int minVal = Integer.MAX_VALUE;
//                 for(int keyy : lru.keySet()){
//                     if(lru.get(keyy) < minVal){
//                         minKey = keyy;
//                         minVal = lru.get(keyy);
//                     }
//                 }
//                 lru.remove(minKey);
//                 map.remove(minKey);
//                 map.put(key, value);
//                 lru.put(key, last);
//             }
//         }
//         last++;
//     }
// }