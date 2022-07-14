package com.skillsoft.datastructures;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

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

            // Not standard but i did not like the -> would be rendered at the end
            System.out.print(pair + (leftChild != null || rightChild != null ? "->" : ""));

        }
    }

    public static void main(String[] args) {

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("Bob");
        Node<String> c = new Node<>("Charles");
        Node<String> d = new Node<>("Dora");
        Node<String> e = new Node<>("Elsa");
        Node<String> f = new Node<>("Fiona");
        Node<String> g = new Node<>("Greg");
        Node<String> h = new Node<>("Harry");

        a.setLeftChild(b);
        a.setRightChild(c);

        System.out.println("\n");
        breadthFirst(a);

        b.setRightChild(d);

        System.out.println("\n");
        breadthFirst(a);

        c.setRightChild(e);

        System.out.println("\n");
        breadthFirst(a);


        d.setRightChild(f);
        d.setRightChild(h);

        System.out.println("\n");

        e.setRightChild(g);
        breadthFirst(a);
    }
}