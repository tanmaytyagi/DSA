package com.dsa.algorithms.Tree;
import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

/*
Given a binary tree, you need to compute the length of the tree’s diameter.
The diameter of a binary tree is the length of the longest path between any
two nodes in a tree. This path may or may not pass through the root.
 */

public class DiameterOfTree {

    public static class Pair {
        int height;
        int diameter;
    }

    public static Pair func(TreeNode root) {
        if(root == null) return new Pair();

        Pair l = func(root.left);
        Pair r = func(root.right);
        Pair ans = new Pair();

        ans.height = 1 + Math.max(l.height, r.height);
        ans.diameter = Math.max(l.diameter, r.diameter);
        ans.diameter = Math.max(ans.diameter, 1 + l.height + r.height);

        return ans;
    }

    public static int diameterOfTree(TreeNode root) {
        Pair pair = func(root);
        return pair.diameter - 1;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();
        System.out.println(diameterOfTree(root));
    }
}
