package ru.matthew8913.trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    public void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.val);
    }
}
