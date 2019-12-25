package xyz.mdou.leetcode;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

public class BTree {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode rebuildBTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return internalRebuildBTree(preOrder, 0, preOrder.length - 1, 0);
    }

    private TreeNode internalRebuildBTree(int[] preOrder, int leftPoint, int rightPoint, int basicPoint) {
        if (leftPoint > rightPoint) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[leftPoint]);
        int rootIndex = indexMap.get(root.getValue());
        int leftTreeLength = rootIndex - basicPoint;
        TreeNode left = internalRebuildBTree(preOrder, leftPoint + 1, leftPoint + leftTreeLength, basicPoint);
        TreeNode right = internalRebuildBTree(preOrder, leftPoint + leftTreeLength + 1, rightPoint,
                basicPoint + leftTreeLength + 1);
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    public static void main(String[] args) {
        BTree bTree = new BTree();
        int[] preOrder = new int[] { 3, 9, 20, 7, 15, 8 };
        int[] inOrder = new int[] { 20, 9, 7, 3, 15, 8 };
        TreeNode root = bTree.rebuildBTree(preOrder, inOrder);
        System.out.println(root);
    }

    @Data
    public class TreeNode {

        private Integer value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }
}