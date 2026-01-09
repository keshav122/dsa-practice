package com.leetcode_practice.problems.medium;

public class MaximumProductOfSplittedBinaryTree_1339 {
    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
        long totalSum = getTotalSum(root);
        State res = dfs(root, totalSum);
        return (int) (res.maxProduct % MOD);
    }

    private long getTotalSum(TreeNode root) {
        if (root == null)
            return 0;
        return getTotalSum(root.left) + getTotalSum(root.right) + root.val;
    }

    private State dfs(TreeNode root, long totalSum) {
        if (root == null)
            return new State(0, 0);
        State left = dfs(root.left, totalSum);
        State right = dfs(root.right, totalSum);

        long subSum = left.sum + right.sum + root.val;
        long product = subSum * (totalSum - subSum);
        long best = Math.max(product, Math.max(left.maxProduct, right.maxProduct));
        return new State(subSum, best);
    }

    static class State {
        long sum;
        long maxProduct;

        public State(long sum, long maxProduct) {
            this.sum = sum;
            this.maxProduct = maxProduct;
        }
    }
}
