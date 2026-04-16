package ru.matthew8913.trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursive(root, result);
        return result;
    }

    public void preorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorderTraversalRecursive(root.left, result);
        preorderTraversalRecursive(root.right, result);
    }

}
