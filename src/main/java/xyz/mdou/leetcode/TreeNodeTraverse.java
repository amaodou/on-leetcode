package xyz.mdou.leetcode;

import java.util.*;

public class TreeNodeTraverse {

    static class Node {
        int value;
        Node left;
        Node right;

        Node (int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{value:" + value + "} ";
        }
    }

    public static void main(String[] args) {
        Node d = new Node(4, null, null);
        Node e = new Node(5, null, null);
        Node b = new Node(2, d, e);

        Node f = new Node(6, null, null);
        Node c = new Node(3, null, f);
        Node root = new Node(1, b, c);

        TreeNodeTraverse task = new TreeNodeTraverse();
        System.out.println(">>> pre order traverse:");
        task.preOrderTraverse(root).forEach(System.out::print);
        System.out.println();
        task.preOrderTraverse2(root).forEach(System.out::print);
        System.out.println();

        System.out.println(">>> post order traverse:");
        task.postOrderTraverse(root).forEach(System.out::print);
        System.out.println();
        task.postOrderTraverse2(root).forEach(System.out::print);

    }

    private List<Node> preOrderTraverse2(Node root) {
        List<Node> nodes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                nodes.add(node);
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        }
        return nodes;
    }

    private List<Node> preOrderTraverse(Node root) {
        List<Node> nodes = new ArrayList<>();
        if (root == null) {
            return null;
        }
        nodes.add(root);
        if (root.left != null) {
            nodes.addAll(preOrderTraverse(root.left));
        }
        if (root.right != null) {
            nodes.addAll(preOrderTraverse(root.right));
        }
        return nodes;
    }

    /**
     * 后序遍历（递归方式）
     */
    private List<Node> postOrderTraverse(Node root) {
        List<Node> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        if (root.left != null) {
            nodes.addAll(postOrderTraverse(root.left));
        }
        if (root.right != null) {
            nodes.addAll(postOrderTraverse(root.right));
        }
        nodes.add(root);
        return nodes;
    }

    /**
     * 后序遍历（非递归方式）
     * 1. 依次遍历节点的左子节点，放入栈中，直到左子节点为空
     * 2. peek获取栈顶节点
     *      如果右子树为空，则直接输出当前节点，pop出栈
     *      如果右子树不为空，则按照方式1先遍历右子节点的左子节点
     *      （需要记录那些节点被peek操作过，如果下次再回到这个节点，直接输出）
     * 3. 当右子节点遍历完成后，再输出根节点
     */
    private List<Node> postOrderTraverse2(Node root) {
        List<Node> nodes = new ArrayList<>();
        Set<Node> peekNodes = new HashSet<>();

        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || peekNodes.contains(node)) {
                nodes.add(node);
                stack.pop();
                node = null;
            } else {
                peekNodes.add(node);
                node = node.right;
            }
        }
        return nodes;
    }
}
