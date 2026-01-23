package com.dsa.algorithms.Tree;

import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

public class ConvertArrayToBST {

    public static TreeNode func(int[] a, int i, int j) {
        if(j < i) return null;

        int mid = i + ((j - i) / 2);

        TreeNode root = new TreeNode(a[mid]);
        root.left = func(a, i , mid - 1);
        root.right = func(a , mid + 1, j);

        return root;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6}; // should be sorted
        TreeNode root = func(a, 0, a.length - 1);
        preorder(root);
    }
}
