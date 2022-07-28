package com.skillsoft.datastructures;

public class Main {

    public static <T> Boolean isFull(Node<T> root) {

        if (root == null) {
            return true;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return true;
        }
        if (root.getLeftChild() != null && root.getRightChild() != null) {
            return isFull(root.getLeftChild()) && isFull(root.getRightChild());
        }

        return false;
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
        Node<String> j = new Node<>("Janet");


        a.setLeftChild(b);
        a.setRightChild(c);

        System.out.println();
        System.out.println("Tree with 3 nodes isFull?: " + isFull(a));

        c.setLeftChild(d);
        c.setRightChild(e);

        System.out.println();
        System.out.println("Tree with 5 nodes isFull?: " + isFull(a));

        d.setLeftChild(f);
        d.setRightChild(h);

        System.out.println();
        System.out.println("Tree with 7 nodes isFull?: " + isFull(a));

        b.setLeftChild(i);
        b.setRightChild(j);

        System.out.println();
        System.out.println("Tree with 9 nodes isFull?: " + isFull(a));


        b.setRightChild(null);

        System.out.println();
        System.out.println("Tree with 8 nodes isFull?: " + isFull(a));
    }
}