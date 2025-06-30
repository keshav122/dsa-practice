package com.dsa_series.roadmap.binary_trees.theory_traversals;

import java.util.*;
//The basic idea is to follow the root 
//Preorder : Root -> Left -> Right
//Inorder : Left -> Root -> Right
//Postorder : Left -> Right -> Root

public class PrePostInOrderTraversalsInOneTraversal {
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        if (root == null)
            return Arrays.asList(inorder, preorder, postorder);
        Stack<NodeState> st = new Stack<>();
        st.push(new NodeState(root, 1));

        while (!st.isEmpty()) {
            NodeState top = st.pop();
            TreeNode node = top.node;
            int state = top.state;

            if (state == 1) {
                preorder.add(node.data);
                st.push(new NodeState(node, 2));
                if (node.left != null) {
                    st.push(new NodeState(node.left, 1));
                }
            } else if (state == 2) {
                inorder.add(node.data);
                st.push(new NodeState(node, 3));
                if (node.right != null) {
                    st.push(new NodeState(node.right, 1));
                }
            } else {
                postorder.add(node.data);
            }
        }
        return Arrays.asList(inorder, preorder, postorder);
    }
}

class NodeState {
    TreeNode node;
    int state;

    NodeState(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}
