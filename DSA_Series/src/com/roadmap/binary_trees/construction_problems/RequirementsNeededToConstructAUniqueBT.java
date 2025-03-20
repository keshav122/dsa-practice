package com.roadmap.binary_trees.construction_problems;

public class RequirementsNeededToConstructAUniqueBT {
    public boolean uniqueBinaryTree(int a, int b) {
        if (a != 2 && b != 2)
            return false;
        return !((a + b) % 2 == 0);

    }
}
