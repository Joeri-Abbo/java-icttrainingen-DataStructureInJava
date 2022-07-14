package com.skillsoft.datastructures;

import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static <T> void breadthFirst(Node<T> root) {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            System.out.print(node + "->");

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }

    public static void main(String[] args) {

        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        a.setLeftChild(b);
        a.setRightChild(c);

        System.out.println("\n");
        breadthFirst(a);

        c.setLeftChild(d);
        c.setRightChild(e);

        System.out.println("\n");
        breadthFirst(a);

        d.setLeftChild(f);
        d.setRightChild(h);

        System.out.println("\n");
        breadthFirst(a);

        e.setRightChild(g);

        System.out.println("\n");
        breadthFirst(a);
        //
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);
//        System.out.println(f);
//        System.out.println(g);
//        System.out.println(h);
    }
}