package ru.matthew8913.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {
        RightSideView solution = new RightSideView();

        // Test case 1: Normal tree
        //     1
        //    / \
        //   2   3
        //    \
        //     5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        System.out.println("Test case 1:");
        System.out.println(solution.rightSideView(root1));
        System.out.println("Expected: [1, 3, 5]");
        System.out.println();

        // Test case 2: Empty tree
        System.out.println("Test case 2:");
        System.out.println(solution.rightSideView(null));
        System.out.println("Expected: []");
        System.out.println();

        // Test case 3: Single node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test case 3:");
        System.out.println(solution.rightSideView(root3));
        System.out.println("Expected: [1]");
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
        }
        return res;
    }
}
