package com.skillsoft.datastructures;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static Node<Integer> insert(Node<Integer> root, int data) {

        if (root == null) {
            return new Node<Integer>(data);
        }

        if (data <= root.getData()) {
            root.setLeftChild(insert(root.getLeftChild(), data));
        } else {
            root.setRightChild(insert(root.getRightChild(), data));
        }

        return root;
    }

    public static <T> void breadthFirst(Node<T> root) {
        if (root == null) {
            return;
        }
        Queue<Pair<Node<T>, Integer>> queue = new LinkedList<>();

        int level = 0;
        queue.add(new Pair<>(root, level));
        while (!queue.isEmpty()) {

            Pair<Node<T>, Integer> pair = queue.remove();
            // Moved to below with a small improvement.
//            System.out.print(pair + "->");

            level = pair.getValue() + 1;

            Node<T> leftChild = pair.getKey().getLeftChild();
            if (leftChild != null) {
                queue.add(new Pair<>(leftChild, level));
            }

            Node<T> rightChild = pair.getKey().getRightChild();
            if (rightChild != null) {
                queue.add(new Pair<>(rightChild, level));
            }

            // Not standard but I did not like the -> would be rendered at the end
            System.out.print(pair + (leftChild != null || rightChild != null ? "->" : ""));

        }
    }

    public static <T> void inOrder(Node<T> root) {

        if (root == null) {
            return;
        }

        inOrder(root.getLeftChild());

        System.out.print(root.getData() + " -> ");

        inOrder(root.getRightChild());

    }
    public static void main(String[] args) {

        Node<Integer> eight = new Node<>(8);

        insert(eight, 3);
        insert(eight, 10);

        System.out.println();
        breadthFirst(eight);

        insert(eight, 1);
        insert(eight, 14);

        System.out.println();
        breadthFirst(eight);

        insert(eight, 6);
        insert(eight, 4);
        insert(eight, 7);
        insert(eight, 13);

        System.out.println();
        breadthFirst(eight);


        System.out.println();
        System.out.println("In order");
        inOrder(eight);

        insert(eight, 2);
        System.out.println();
        breadthFirst(eight);

        insert(eight, 12);
        System.out.println();
        breadthFirst(eight);



    }


}