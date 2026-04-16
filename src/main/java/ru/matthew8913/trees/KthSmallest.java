package ru.matthew8913.trees;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestRec(root, new int[1], k);
    }

    public int kthSmallestRec(TreeNode root, int[] count, int k) {
        if (root == null) return -1;

        int leftVal = kthSmallestRec(root.left, count, k);
        if (leftVal != -1) return leftVal;

        if (++count[0] == k) return root.val;

        return kthSmallestRec(root.right, count, k);
    }
}
