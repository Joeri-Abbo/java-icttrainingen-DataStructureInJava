package com.skillsoft.datastructures;

import java.util.Stack;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static <T> void inOrder(Node<T> root) {

        if (root == null) {
            return;
        }

        inOrder(root.getLeftChild());

        System.out.print(root.getData() + " -> ");

        inOrder(root.getRightChild());

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

        System.out.println("\n");
        inOrder(a);

        c.setRightChild(e);

        System.out.println("\n");
        inOrder(a);

    }
}