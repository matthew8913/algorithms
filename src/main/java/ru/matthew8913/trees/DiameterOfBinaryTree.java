package ru.matthew8913.trees;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        d[0] = 0;
        maxDepth(root, d);
        return d[0];
    }


    public int maxDepth(TreeNode root, int[] d) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left, d);

        int maxRight = maxDepth(root.right, d);

        d[0] = Math.max(d[0], maxLeft + (maxLeft > 0 ? 1 : 0) + maxRight + (maxRight > 0 ? 1 : 0));

        return Math.max(maxLeft, maxRight);
    }
}
