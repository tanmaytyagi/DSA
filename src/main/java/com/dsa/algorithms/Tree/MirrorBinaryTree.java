package com.dsa.algorithms.Tree;

import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

public class MirrorBinaryTree {

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode invertedLeft = mirrorTree(root.left);
        TreeNode invertedRight = mirrorTree(root.right);
        root.left = invertedRight;
        root.right = invertedLeft;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();
        preorder(root);
        root = mirrorTree(root);
        System.out.println();
        preorder(root);
    }
}
