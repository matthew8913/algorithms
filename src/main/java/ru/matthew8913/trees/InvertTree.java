package ru.matthew8913.trees;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeRecursive(root);
        return root;
    }

    public void invertTreeRecursive(TreeNode root) {
        if (root == null) return;

        swap(root);
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
