package com.skillsoft.datastructures;

import java.util.Map;
import java.util.HashMap;
public class Main {

    public static <T> Boolean isBalanced(Node<T> root,
            Map<Node<T>, Integer> nodeHeightMap) {

        if (root == null) {
            return true;
        }

        boolean isLeftBalanced = isBalanced(root.getLeftChild(), nodeHeightMap);
        boolean isRightBalanced = isBalanced(root.getRightChild(), nodeHeightMap);

        int leftHeight = nodeHeightMap.getOrDefault(root.getLeftChild(), 0);
        int rightHeight = nodeHeightMap.getOrDefault(root.getRightChild(), 0);


        nodeHeightMap.put(root, Math.max(leftHeight, rightHeight) + 1);

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return isLeftBalanced && isRightBalanced;
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
        System.out.println("Tree with 3 nodes isComplete?: " +
                isBalanced(a, new HashMap<Node<String>,Integer>()));

        b.setLeftChild(f);
        f.setLeftChild(h);

        c.setLeftChild(d);
        c.setLeftChild(e);

        e.setLeftChild(i);

        System.out.println();
        System.out.println("Tree with 8 nodes isComplete?: " +
                isBalanced(a, new HashMap<Node<String>,Integer>()));

    }


}