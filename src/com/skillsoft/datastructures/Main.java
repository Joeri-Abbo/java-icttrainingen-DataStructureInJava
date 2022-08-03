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

    public static Node<Integer> lookup(Node<Integer> root, int data) {

        if (root == null) {
            return null;
        }

        if (data == root.getData()) {
            return root;
        }

        if (data <= root.getData()) {
            System.out.println(data + " <= " + root.getData() + " looking in the left subtree");
            return lookup(root.getLeftChild(), data);
        } else {
            System.out.println(data + "  > " + root.getData() + " looking in the right subtree");
            return lookup(root.getRightChild(), data);
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

    public static Integer minimumValue(Node<Integer> root) {
        int minValue = Integer.MAX_VALUE;
        while (root != null) {
            minValue = root.getData();
            System.out.println("Currently at node:" + minValue + " going into the left subtree");
            root = root.getLeftChild();
        }

        return minValue;
    }
    public static Integer maximumValue(Node<Integer> root) {
        int maxValue = Integer.MAX_VALUE;
        while (root != null) {
            maxValue = root.getData();
            System.out.println("Currently at node:" + maxValue + " going into the right subtree");
            root = root.getRightChild();
        }

        return maxValue;
    }

    public static void main(String[] args) {

        Node<Integer> eight = new Node<>(8);

        insert(eight, 3);
        insert(eight, 10);
        insert(eight, 1);
        insert(eight, 14);
        insert(eight, 6);
        insert(eight, 4);
        insert(eight, 7);
        insert(eight, 13);

        System.out.println("Minimum value " + minimumValue(eight));
        System.out.println("Maximum value " + maximumValue(eight));

        System.out.println();
        System.out.println("In order");
        inOrder(eight);

        System.out.println();
        insert(eight, -10);
        System.out.println("Minimum value " + minimumValue(eight));
        System.out.println("Maximum value " + maximumValue(eight));

        System.out.println();
        insert(eight, 19);
        System.out.println("Minimum value " + minimumValue(eight));
        System.out.println("Maximum value " + maximumValue(eight));

    }
}