package com.skillsoft.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static <T> void mirror(Node<T> root) {

        if (root == null) {
            return ;
        }

        Node<T> temporary = root.getLeftChild();

        root.setLeftChild(root.getRightChild());
        root.setRightChild(temporary);

        mirror(root.getLeftChild());
        mirror(root.getRightChild());
    }

    public static <T> void breadthFirst(Node<T> root){

        if (root == null) {
            return ;
        }
        Queue<Pair<Node<T>, Integer>> queue = new LinkedList<>();

        int level = 0;

        queue.add(new Pair<>(root,level));

        while (!queue.isEmpty()) {

            Pair<Node<T>, Integer> pair = queue.remove();
            System.out.println(pair + "->");

            level = pair.getValue() + 1;

            Node<T> leftChild = pair.getKey().getLeftChild();
            if (leftChild != null) {
                queue.add(new Pair<>(leftChild, level));
            }

            Node<T> rightChild = pair.getKey().getRightChild();
            if (rightChild != null) {
                queue.add(new Pair<>(rightChild, level));
            }

        }
    }

    public static void main(String[] args) {

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);

        one.setLeftChild(two);
        one.setRightChild(three);

        three.setLeftChild(seven);
        three.setRightChild(six);

        seven.setLeftChild(eight);

        six.setLeftChild(five);
        six.setRightChild(four);

        System.out.println();
        System.out.println("Original: ");
        breadthFirst(one);

        System.out.println();
        System.out.println();
        System.out.println("Mirror: ");
        mirror(one);
        breadthFirst(one);
    }
}