public class Solution {
    private int N = (int)1e5 + 10;
    private int[] height = new int[N], ans = new int[N], queriesAns;
    public int[] treeQueries(TreeNode root, int[] queries) {
        queriesAns = new int[queries.length];
        getHeight(root);
        dfs(root, null, null, -1);
        for (int i = 0; i < queries.length; i++) {
            queriesAns[i] = ans[queries[i]];
        }
        return queriesAns;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return height[root.val] = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private void dfs(TreeNode root, TreeNode par, TreeNode other, int depth) {
        if (root == null) return;
        if (par == null) {
            ans[root.val] = 0;
        } else {
            ans[root.val] = Math.max(ans[par.val], (other == null ? 0 : height[other.val]) + depth);
        }
        dfs(root.left, root, root.right, depth + 1);
        dfs(root.right, root, root.left, depth + 1);
    }
}