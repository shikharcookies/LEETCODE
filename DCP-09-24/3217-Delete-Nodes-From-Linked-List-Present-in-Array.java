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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set <Integer> set = new HashSet<>();
        for(int i:nums)
        {
            set.add(i);
        }
        ListNode prev = null, node = head;
        while(node!=null)
        {
            if(set.contains(node.val))
            {
              if(prev!=null){
                prev.next=node.next; // remove
              } 
              else{
                head=node.next;
              }
            }
            else{
                prev = node; // set prev node = node
            }
            node = node.next;
        }
        return head;
    }
}