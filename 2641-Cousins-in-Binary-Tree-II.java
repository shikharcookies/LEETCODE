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
    public TreeNode replaceValueInTree(TreeNode root) {
        updateVal(root, 0, levelSum(root));
        root.val = 0;
        return root;

        
    }
    private void updateVal (TreeNode root, int level, List<Long> levelSum) 
    {
        if(root==null || level+1==levelSum.size()) return;

        //calculating cousins sum
        long nextLevelSum =levelSum.get(level+1);
        if(root.left!=null) nextLevelSum-=root.left.val;
        if(root.right!=null) nextLevelSum-=root.right.val;

        //updating values of children
        if(root.left!=null) root.left.val = (int)nextLevelSum ;
        if(root.right!=null) root.right.val = (int)nextLevelSum;

        // call function updateVal for left and right child
        updateVal(root.left, level+1, levelSum);
        updateVal(root.right, level+1, levelSum);

    }

    private List<Long> levelSum(TreeNode root)
    {
        List<Long> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            long sum=0;
            for(int i=0;i<size;i++)
            {
               TreeNode curr = q.remove();
               sum+=curr.val; 
               if(curr.left!=null) q.add(curr.left);
               if(curr.right!=null) q.add(curr.right);
            }
            ans.add(sum);
        }
        return ans;
    }
}