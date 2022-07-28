package com.skillsoft.datastructures;

public class Main {

    public static <T> int leftDepth(Node<T> root) {
        int leftDepth = 0;

        Node<T> node = root;

        while(node != null){

            leftDepth++;

            node = node.getLeftChild();
        }

        return leftDepth - 1;
    }
    public static <T> Boolean isPerfectRecursive(Node<T> root, int leftDepth, int currentLevel) {

        if (root == null) {
            return true;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return currentLevel == leftDepth;
        }

        if (root.getLeftChild() == null || root.getRightChild() == null) {
            return false;
        }

        return isPerfectRecursive(root.getLeftChild(), leftDepth, currentLevel + 1) &&
                isPerfectRecursive(root.getRightChild(), leftDepth, currentLevel + 1);
    }

    public static <T> Boolean isPerfect(Node<T> root) {
        return isPerfectRecursive(root, leftDepth(root), 0);
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
        System.out.println("Tree with 3 nodes isPerfect?: " + isPerfect(a));

        b.setLeftChild(g);
        b.setRightChild(h);

        c.setLeftChild(e);
        c.setRightChild(f);

        System.out.println();
        System.out.println("Tree with 7 nodes isPerfect?: " + isPerfect(a));

        b.setLeftChild(null);
        b.setRightChild(null);

        System.out.println();
        System.out.println("Tree with 5 nodes isPerfect?: " + isPerfect(a));

        b.setLeftChild(g);
        System.out.println("Tree with 6 nodes isPerfect?: " + isPerfect(a));

    }
}