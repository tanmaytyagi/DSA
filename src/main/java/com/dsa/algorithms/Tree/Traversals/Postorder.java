package com.dsa.algorithms.Tree.Traversals;
import java.util.Stack;

import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

public class Postorder {

    private static void postorderRecursive(TreeNode root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    private static void postorderIterative(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> temp = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        temp.push(root);
        while(!temp.isEmpty()) {
            TreeNode top = temp.pop();
            ans.push(top.val);
            if(top.left != null) temp.push(top.left);
            if(top.right != null) temp.push(top.right);
        }
        while(!ans.isEmpty()) {
            System.out.print(ans.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();
        postorderIterative(root);
    }
}
