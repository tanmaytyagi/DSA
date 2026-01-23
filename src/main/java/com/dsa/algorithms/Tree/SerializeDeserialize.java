package com.dsa.algorithms.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dsa.algorithms.Tree.BinaryTreeUtil.*;

public class SerializeDeserialize {

    public static void store(TreeNode root, List<String> s) {
        if (root == null) {
            s.add("null");
            return;
        }
        s.add(root.val.toString());
        store(root.left, s);
        store(root.right, s);
    }

    public static List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        store(root, list);
        return list;
    }

    public static TreeNode deserialize(List<String> s) {
        if(s.isEmpty()) return null;
        if(s.getLast().equals("null")) {
            s.removeLast();
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s.getLast()));
        s.removeLast();
        root.left = deserialize(s);
        root.right = deserialize(s);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();

        List<String> list = serialize(root);
        System.out.println(list);
        Collections.reverse(list);
        TreeNode node = deserialize(list);
        preorder(node);
    }
}
