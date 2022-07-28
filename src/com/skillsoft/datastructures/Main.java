package com.skillsoft.datastructures;

public class Main {

    public static <T> int maxDepth(Node<T> root) {

        if (root == null) {
            return 0;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            System.out.println(root + " maxDepth : " + 0);
            return 0;
        }

        int leftMaxDepth = maxDepth(root.getLeftChild());
        int rightMaxDepth = maxDepth(root.getRightChild());

        int maxDepth = 1 + Math.max(leftMaxDepth, rightMaxDepth);

        System.out.println(root + "" +
                " left : maxDepth " + leftMaxDepth +
                " right : maxDepth" + rightMaxDepth +
                "current maxDepth : " + maxDepth);
        return maxDepth;
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

        System.out.println();
        System.out.println("Tree with 3 nodes maxDepth : " + maxDepth(a));

        b.setLeftChild(d);
        b.setRightChild(e);

        System.out.println();
        System.out.println("Tree with 5 nodes maxDepth : " + maxDepth(a));

        e.setLeftChild(f);
        e.setRightChild(g);

        f.setRightChild(h);
        h.setRightChild(i);

        System.out.println();
        System.out.println("Tree with 9 nodes maxDepth : " + maxDepth(a));

    }
}