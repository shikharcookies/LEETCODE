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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int length=0;
        ListNode node = head;
        while(node!=null)
        {
            length+=1;
            node=node.next;

        }
        node = head;
        int size= length/k;
        int extra = length%k;
        for(int i=0;i<k;i++)
        {
            if(node==null) break;
            ans[i]=node;
            ListNode prev = null;
            for(int j=0;j<size;j++)
            {
                prev = node;
                node = node.next;
            }
            if(extra >0)
            {
                prev = node;
                node = node.next;
                extra-=1;
            }
            prev.next= null;
        }
        return ans;
    }
}