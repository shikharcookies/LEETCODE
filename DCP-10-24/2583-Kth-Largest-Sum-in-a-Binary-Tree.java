/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            long sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.remove();
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(pq.size()<k) pq.add(sum);
            else if(pq.peek()<sum)
            {
                pq.remove();
                pq.add(sum);
            }
        }
        if(pq.size()<k) return -1;
        return pq.peek();
    }
}