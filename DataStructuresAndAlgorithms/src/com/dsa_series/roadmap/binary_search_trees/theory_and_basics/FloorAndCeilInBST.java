package com.roadmap.binary_search_trees.theory_and_basics;

import java.util.ArrayList;
import java.util.List;

public class FloorAndCeilInBST {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> li = new ArrayList<>();
        li.add(floorOfBST(root, key));
        li.add(ceilOfBST(root, key));
        return li;
    }

    private Integer floorOfBST(TreeNode root, int key) {
        int value = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data < key) {
                value = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return value;
    }

    private Integer ceilOfBST(TreeNode root, int key) {
        int value = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data > key) {
                value = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return value;
    }

}
