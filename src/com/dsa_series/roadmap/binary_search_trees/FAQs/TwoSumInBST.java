package com.dsa_series.roadmap.binary_search_trees.FAQs;

/*Author: keshav122 */
package com.roadmap.binary_search_trees.FAQs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TwoSumInBST {
    public boolean twoSumBST_BF(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        inorder(root, inorderList, indexMap);
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            if (indexMap.containsKey(k - entry.getKey()) && indexMap.get(k - entry.getKey()) != entry.getValue()) {
                return true;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> inorderList, Map<Integer, Integer> indexMap) {
        if (root == null)
            return;
        inorder(root.left, inorderList, indexMap);
        inorderList.add(root.data);
        indexMap.put(root.data, inorderList.size() - 1);
        inorder(root.right, inorderList, indexMap);
    }

    public boolean twoSumBST_Better(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        return twoSum(inorderList, k, inorderList.size());
    }

    private boolean twoSum(List<Integer> li, int k, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int sum = li.get(i) + li.get(j);
            if (sum == k)
                return true;
            else if (sum < k)
                i++;
            else
                j--;
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> inorderList) {
        if (root == null)
            return;
        inorder(root.left, inorderList);
        inorderList.add(root.data);
        inorder(root.right, inorderList);
    }

    public boolean twoSumBST_Left(TreeNode root, int k) {
        if (root == null)
            return false;
        // normal Inorder
        BSTIterator l = new BSTIterator(root, false);
        // reverse Inorder
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k)
                return true;
            else if (i + j < k)
                i = l.next();
            else
                j = r.next();
        }
        return false;
    }

}

class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAllValues(root);
    }

    private void pushAllValues(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = (reverse) ? root.right : root.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode top = st.pop();
        if (!reverse)
            pushAllValues(top.right);
        else
            pushAllValues(top.left);
        return top.data;
    }
}
