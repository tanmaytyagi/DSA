package com.dsa.algorithms.Tree;

import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

public class MaxSumPath {

    public static class Pair {
        int included;
        int excluded;
    }

    public static int maxValue(int... a) {
        int max = -100000;
        for(int x : a) max = Math.max(max, x);
        return max;
    }

    public static Pair func(TreeNode root) {
        if(root == null) return new Pair();

        Pair l = func(root.left);
        Pair r = func(root.right);

        int included = maxValue(l.included + root.val, r.included + root.val, root.val);
        int excluded = maxValue(l.included, r.included, l.excluded, r.excluded, l.included + r.included + root.val);

        Pair ans = new Pair();
        ans.included = included;
        ans.excluded = excluded;
        return ans;
    }

    public static int maxPathSum(TreeNode root) {
        Pair p = func(root);
        return maxValue(p.included, p.excluded);
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();
        System.out.println(maxPathSum(root));
    }
}
