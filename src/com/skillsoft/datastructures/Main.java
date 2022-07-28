package com.skillsoft.datastructures;

public class Main {

    public static <T> boolean hasPathSum(Node<T> root, int currentSum) {

        if (root == null) {
            return false;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return currentSum == root.getData();
        }

        boolean hasPathSumLeft = hasPathSum(root.getLeftChild(), currentSum - root.getData());
        boolean hasPathSumRight = hasPathSum(root.getRightChild(), currentSum - root.getData());

        boolean hasPathSum = hasPathSumLeft || hasPathSumRight;

        System.out.println(root + "" +
                " hasPathSumLeft : " + hasPathSumLeft +
                " hasPathSumRight : " + hasPathSumRight +
                " hasPathSum : " + hasPathSum);
        return hasPathSum;
    }

    public static void main(String[] args) {

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);

        one.setLeftChild(two);
        one.setRightChild(three);

        three.setLeftChild(seven);
        three.setRightChild(six);

        seven.setLeftChild(eight);

        six.setLeftChild(five);
        six.setLeftChild(four);

        System.out.println();
        System.out.println("HasPathSum 3: " + hasPathSum(one, 3));

        System.out.println();
        System.out.println("HasPathSum 25: " + hasPathSum(one, 25));

        System.out.println();
        System.out.println("HasPathSum 19: " + hasPathSum(one, 19));


    }
}