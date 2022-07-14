package com.skillsoft.datastructures;

import java.util.Stack;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static <T> void inOrder(Node<T> root) {

        if (root == null) {
            return;
        }

        Set<Node<T>> visitedNodes = new HashSet<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<T> top = stack.pop();

            if (top.getLeftChild() == null && top.getRightChild() == null) {
                System.out.print(top + "->");
            } else if (visitedNodes.contains(top)) {
                System.out.print(top + "->");
            } else {
                visitedNodes.add(top);

                if (top.getRightChild() != null) {
                    stack.push(top.getRightChild());
                }

                stack.push(top);

                if (top.getLeftChild() != null) {
                    stack.push(top.getLeftChild());
                }
            }
        }
    }

    public static void main(String[] args) {

        Node<String> a = new Node<>("Alice");
        Node<String> b = new Node<>("Bob");
        Node<String> c = new Node<>("Charles");
        Node<String> d = new Node<>("Dora");
        Node<String> e = new Node<>("Elsa");
        Node<String> f = new Node<>("Fiona");
        Node<String> g = new Node<>("Greg");
        Node<String> h = new Node<>("Harry");
        Node<String> i = new Node<>("Irene");

        a.setLeftChild(b);
        a.setRightChild(c);

        System.out.println("\n");
        inOrder(a);

        b.setLeftChild(d);
        b.setRightChild(e);

        c.setLeftChild(f);
        c.setRightChild(g);

        System.out.println("\n");
        inOrder(a);

        d.setLeftChild(h);
        d.setRightChild(i);

        System.out.println("\n");
        inOrder(a);
    }
}