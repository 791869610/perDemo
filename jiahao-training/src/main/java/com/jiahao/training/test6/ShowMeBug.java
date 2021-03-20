package com.jiahao.training.test6;

import java.util.Objects;

public class ShowMeBug {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(2);
        TreeNode rootLeftLeft = new TreeNode(3);
        TreeNode rootLeftRight = new TreeNode(4);
        TreeNode rootRightLeft = new TreeNode(5);
        TreeNode rootRightRight = new TreeNode(6);
        TreeNode rootRLL = new TreeNode(7);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;
        rootRightLeft.left = rootRLL;
        postOrder(root);
    }

    public static void postOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}

