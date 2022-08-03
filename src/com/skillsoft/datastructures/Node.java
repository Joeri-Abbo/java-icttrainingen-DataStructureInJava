package com.skillsoft.datastructures;

public class Node<Integer> {
    private int data;
    private Node<Integer> leftChild;
    private Node<Integer> rightChild;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node<Integer> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<Integer> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<Integer> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<Integer> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
