package com.skillsoft.datastructures;

public class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "\nData: " + data.toString() +
                " Left child: " + ((leftChild == null) ? "" : leftChild.getData()) +
                " Right child: " + ((rightChild == null) ? "" : rightChild.getData());
    }
}
