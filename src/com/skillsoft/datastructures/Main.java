package com.skillsoft.datastructures;

public class Main {

    public static <T> int countNodes(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeftChild()) +
                countNodes(root.getRightChild());
    }
    public static <T> Boolean isComplete(Node<T> root, int currentNodeIndex, int totalNodes) {

        if (root == null) {
            return true;
        }

        if (currentNodeIndex >= totalNodes) {
            return false;
        }

        int leftChildIndex = 2 * currentNodeIndex + 1;
        int rightChildIndex = 2 * currentNodeIndex + 2;
        return isComplete(root.getLeftChild(), leftChildIndex, totalNodes) &&
                isComplete(root.getRightChild(), rightChildIndex, totalNodes);
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
        System.out.println("Tree with 3 nodes isComplete?: " + isComplete(a,0, countNodes(a)));

        b.setLeftChild(f);
        b.setRightChild(g);

        c.setLeftChild(d);
        c.setRightChild(e);

        System.out.println();
        System.out.println("Tree with 7 nodes isComplete?: " + isComplete(a,0, countNodes(a)));

        f.setLeftChild(h);

        System.out.println();
        System.out.println("Tree with 8 nodes isComplete?: " + isComplete(a,0, countNodes(a)));

        f.setLeftChild(i);

        System.out.println();
        System.out.println("Tree with 9 nodes isComplete?: " + isComplete(a,0, countNodes(a)));


        System.out.println();
        System.out.println("Cleaning tree");
        a.setLeftChild(null);
        a.setRightChild(null);
        b.setLeftChild(null);
        b.setRightChild(null);
        c.setLeftChild(null);
        c.setRightChild(null);
        f.setLeftChild(null);
        f.setLeftChild(null);

        a.setLeftChild(b);
        a.setLeftChild(c);

        b.setLeftChild(g);

        c.setLeftChild(d);
        c.setLeftChild(e);

        System.out.println();
        System.out.println("Tree with 6 nodes isComplete?: " + isComplete(a,0, countNodes(a)));

    }


}