package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InOrderTraversal {
    public static void main(String[] args) {

        /*
                50
               /  \
             30    70
            /  \   / \
          20   40 60 80

          inOrder(30), 50, inOrder(70)
          inOrder(20), 30, inOrder(40), 50, inOrder(60), 70, inOrder(80)
          20, 30, 40, 50, 60, 70, 80

          In Order (left, root, right): 20, 30, 40, 50, 60, 70, 80
          Pre Order (root, left, right): 50, 30, 20, 40, 70, 60, 80
          Post Order (left, right, root): 20, 40, 30, 60, 80, 70, 50
          Reverse In Order (right, root, left): 80, 70, 60, 50, 40, 30, 20
        */
        TreeNode root = new TreeNode(50);

        root.left = new TreeNode(30);
        root.right = new TreeNode(70);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        int k = 3;
        List<Integer> list = new ArrayList<Integer>();
        inOrderTraversal(root, list);
        System.out.println(k + "th largest element in BST is " + list.get(k - 1));
    }

    private static void inOrderTraversal(final TreeNode root, final List<Integer> list) {
        if (Objects.isNull(root)) {
            return;
        }

        inOrderTraversal(root.right, list);
        list.add(root.val);
        inOrderTraversal(root.left, list);
    }
}