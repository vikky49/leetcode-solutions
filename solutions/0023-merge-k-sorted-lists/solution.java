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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) {
            return null;
        }

        //create a min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val));

        //Lets add the first nodes 

        for(ListNode node : lists) {
            if(node != null) {
                pq.offer(node);
            }
        }

        //create a new listNode
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            //Add the items to the list
            ListNode node = pq.poll();

            //add the node the currentList 
            current.next = node;
            //update the current
            current = current.next;

            if(node.next != null ) {
                pq.offer(node.next);
            }            
        }
        //dummy.next is the head
        return dummy.next; 
    }
}
