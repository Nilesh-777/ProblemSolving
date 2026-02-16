package com.practice.tree;

public class KthLargestInBinary {

    public static void main(String[] args) {

        /*
                50
               /  \
             30    70
            /  \   / \
          20   40 60 80

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

        int result = findKthLargest(root, k);

        System.out.println("Kth largest element is: " + result);
    }

    /**
     * Business logic should be implemented here
     */
    public static int findKthLargest(final TreeNode root, int k) {
        return -1; // placeholder
    }
}
