package com.dsa.algorithms.Tree;
import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

/*
Given the root of a binary tree, the task is to flatten the tree
into a linked list using the same TreeNode class.
The left child pointer of each node in the linked list should always be NULL,
and the right child pointer should point to the next node in the linked list.
The nodes in the linked list should be in the same order as that of the
preorder traversal of the given binary tree.
 */

public class FlattenBinaryTree {

    public static TreeNode flattenTree(TreeNode root) {
        if (root == null) return null;

        TreeNode l = flattenTree(root.left);
        TreeNode r = flattenTree(root.right);
        root.right = l;

        TreeNode prev = root;
        TreeNode curr = l;
        while (curr != null) {
            prev = curr;
            curr = curr.right;
        }

        prev.right = r;
        root.left = null;
        return root;
    }

    public static void printFlattenTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();
        TreeNode result = flattenTree(root);
        printFlattenTree(result);
    }
}
