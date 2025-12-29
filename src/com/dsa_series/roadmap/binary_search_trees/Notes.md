# **Binary Search Tree (BST) Overview** 

Two properties that BST must follow :
- **Value of Left Node < Value of Root Node < Value of Right Node**
- **Both the left subtree and the right subtrees must also be BSTs.**

A **Binary Search Tree (BST)** is a specialized **binary tree** where:  
- Each node has at most **two children**: **left** and **right**.  
- **Left subtree** contains values **less than** the node.  
- **Right subtree** contains values **greater than** the node.  

## **BST Properties**  
1. **Search Efficiency**: Searching takes **O(log N)** time in a balanced BST.  
2. **Height & Depth**: A well-balanced BST has a height of approximately **log₂(N)**, ensuring fast operations.  
3. **Subtree Rule**: Every subtree of a BST is also a **BST**.  
4. **No Duplicates (Generally)**: Each node has a **unique value**, but some variations allow duplicates.  

## **BST Structure Example**  
```
        8  
       / \  
      3   10  
     / \    \  
    1   6    14  
       / \   /  
      4   7 13  
```
👉 **Search for 7:** Start from root (8) → go left (3) → go right (6) → go right (7) → Found! ✅  

## **Balanced Variants of BST**  
To maintain efficiency, self-balancing BSTs exist:  
- **AVL Tree** 🔄: Ensures balance with rotations; height difference ≤ 1.  
- **Red-Black Tree** 🔴⚫: Uses color rules & rotations to stay balanced.  

## **Real-World Applications**  
✅ **Database Indexing** (efficient lookups)  
✅ **Symbol Tables** (compilers, interpreters)  
✅ **Memory Management** (heap structures) 
# Author: keshav122
