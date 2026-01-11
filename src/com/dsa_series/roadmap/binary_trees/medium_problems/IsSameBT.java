/*Author: keshav122 */
package com.dsa_series.roadmap.binary_trees.medium_problems;

public class IsSameBT {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        if (p.data != q.data) {
            return false;
        }
        boolean leftAns = isSameTree(p.left, q.left);
        boolean rightAns = isSameTree(p.right, q.right);
        if (!leftAns || !rightAns) {
            return false;
        } else {
            return true;
        }
    }

    // Same logic as above but concised
    public boolean isSameTree__better(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }
        return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
