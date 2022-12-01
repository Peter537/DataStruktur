package main.trees;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int data) {
        this.root = insertInto(data, getRoot(), null);
    }

    private BinaryTreeNode insertInto(int data, BinaryTreeNode node, BinaryTreeNode parent) {
        if (node == null) {
            return new BinaryTreeNode(data, parent, null, null);
        }
        if (data == node.getData()) {
            return node;
        }
        if (data < node.getData()) {
            BinaryTreeNode leftChild = insertInto(data, node.getLeftChild(), node);
            node.setLeftChild(leftChild);
        } else {
            BinaryTreeNode rightChild = insertInto(data, node.getRightChild(), node);
            node.setRightChild(rightChild);
        }
        return node;
    }

    public void print() {
        printNode(getRoot());
    }

    private void printNode(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        printNode(node.getLeftChild());
        System.out.println(node.getData());
        printNode(node.getRightChild());
    }

    private BinaryTreeNode getRoot() {
        return root;
    }
}