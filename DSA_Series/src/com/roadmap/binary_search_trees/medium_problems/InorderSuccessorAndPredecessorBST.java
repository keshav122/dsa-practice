package com.roadmap.binary_search_trees.medium_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderSuccessorAndPredecessorBST {
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> li = new ArrayList<>();
        inorderTraversal(root, li);
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int n = li.size();
        while (i < n) {
            if (li.get(i) == key) {
                if (i == 0 || i == n - 1) {
                    handleCornerCases(ans, n, li, i);
                }
                ans.add(li.get(i - 1));
                ans.add(li.get(i + 1));
                return ans;
            }
            i++;
        }
        return ans;

    }

    private void handleCornerCases(List<Integer> ans, int n, List<Integer> li, int i) {
        if (i == 0) {
            ans.add(-1);
            if (n <= 1) {
                ans.add(-1);
            } else {
                ans.add(li.get(i + 1));
            }

        }

        if (i == n - 1) {

            if (n <= 1) {
                ans.add(-1);
            } else {
                ans.add(li.get(i - 1));
            }
            li.add(-1);
        }
    }

    private void inorderTraversal(TreeNode root, List<Integer> li) {
        if (root == null)
            return;
        inorderTraversal(root.left, li);
        li.add(root.data);
        inorderTraversal(root.right, li);
    }

    List<Integer> succPredBST_BF_1(TreeNode root, int key) {
        List<Integer> sortedList = new ArrayList<>();
        inorderTraversal(root, sortedList);
        List<Integer> ans = new ArrayList<>();
        int predecessor = -1;
        int successor = -1;
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) < key) {
                predecessor = sortedList.get(i);
            } else if (sortedList.get(i) > key) {
                successor = sortedList.get(i);
                break;
            }
        }
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }

    List<Integer> succPredBST_Better(TreeNode root, int key) {
        TreeNode succ = null;
        TreeNode pred = null;
        while (root != null) {
            if (root.data == key) {
                if (root.right != null) {
                    succ = findMin(root.right);
                }
                if (root.left != null) {
                    pred = findMax(root.left);
                }
                break;
            } else if (root.data < key) {
                // If current node's value is less than key, move to the right subtree
                pred = root;
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return Arrays.asList(pred == null ? -1 : pred.data, succ == null ? -1 : succ.data);
    }

    // Helper function to find the minimum value node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Helper function to find the maximum value node in a subtree
    private TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Optimal Solution
    private int predecessor = -1;
    private int successor = Integer.MAX_VALUE;

    List<Integer> succPredBST_Optimal(TreeNode root, int key) {
        traverse(root, key);
        return Arrays.asList(
                predecessor == -1 ? -1 : predecessor, successor == Integer.MAX_VALUE ? -1 : successor);
    }

    private void traverse(TreeNode node, int key) {
        if (node == null) {
            return;
        }

        if (node.data < key) {
            predecessor = Math.max(predecessor, node.data);
            traverse(node.right, key);
        } else if (node.data > key) {
            successor = Math.min(successor, node.data);
            traverse(node.left, key);
        }
        // If node's values equals key
        else {
            if (node.left != null) {
                TreeNode temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp.data;
            }

            if (node.right != null) {
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp.data;
            }
        }
    }

}
