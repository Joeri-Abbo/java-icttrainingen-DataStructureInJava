package com.skillsoft.datastructures;

import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static Node<Integer> insert(Node<Integer> root, int data) {

        if (root == null) {
            return new Node<Integer>(data);
        }

        if (data <= root.getData()) {
            root.setLeftChild(insert(root.getLeftChild(), data));
        } else {
            root.setRightChild(insert(root.getRightChild(), data));
        }

        return root;
    }

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

            // Not standard but I did not like the -> would be rendered at the end
            System.out.print(pair + (leftChild != null || rightChild != null ? "->" : ""));

        }
    }

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

    public static Node<Integer> lookup(Node<Integer> root, int data) {

        if (root == null) {
            return null;
        }

        if (data == root.getData()) {
            return root;
        }

        if (data <= root.getData()) {
            System.out.println(data + " <= " + root.getData() + " looking in the left subtree");
            return lookup(root.getLeftChild(), data);
        } else {
            System.out.println(data + "  > " + root.getData() + " looking in the right subtree");
            return lookup(root.getRightChild(), data);
        }
    }

    public static <T> int leftDepth(Node<T> root) {
        int leftDepth = 0;

        Node<T> node = root;

        while (node != null) {

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

        return isPerfectRecursive(root.getLeftChild(), leftDepth, currentLevel + 1) && isPerfectRecursive(root.getRightChild(), leftDepth, currentLevel + 1);
    }

    public static <T> Boolean isPerfect(Node<T> root) {
        return isPerfectRecursive(root, leftDepth(root), 0);
    }

    public static <T> int countNodes(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.getLeftChild()) + countNodes(root.getRightChild());
    }

    public static <T> Boolean isBalanced(Node<T> root, Map<Node<T>, Integer> nodeHeightMap) {

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

    public static <T> Boolean isComplete(Node<T> root, int currentNodeIndex, int totalNodes) {

        if (root == null) {
            return true;
        }

        if (currentNodeIndex >= totalNodes) {
            return false;
        }

        int leftChildIndex = 2 * currentNodeIndex + 1;
        int rightChildIndex = 2 * currentNodeIndex + 2;
        return isComplete(root.getLeftChild(), leftChildIndex, totalNodes) && isComplete(root.getRightChild(), rightChildIndex, totalNodes);
    }

    public static <T> void mirror(Node<T> root) {

        if (root == null) {
            return;
        }

        Node<T> temporary = root.getLeftChild();

        root.setLeftChild(root.getRightChild());
        root.setRightChild(temporary);

        mirror(root.getLeftChild());
        mirror(root.getRightChild());
    }

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

        System.out.println(root + "" + " hasPathSumLeft : " + hasPathSumLeft + " hasPathSumRight : " + hasPathSumRight + " hasPathSum : " + hasPathSum);
        return hasPathSum;
    }

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

        System.out.println(root + "" + " left : maxDepth " + leftMaxDepth + " right : maxDepth" + rightMaxDepth + "current maxDepth : " + maxDepth);
        return maxDepth;
    }

    public static <T> void inOrder(Node<T> root) {

        if (root == null) {
            return;
        }

        inOrder(root.getLeftChild());

        System.out.print(root.getData() + " -> ");

        inOrder(root.getRightChild());

    }

    public static Integer minimumValue(Node<Integer> root) {
        int minValue = Integer.MAX_VALUE;
        while (root != null) {
            minValue = root.getData();
            System.out.println("Currently at node:" + minValue + " going into the left subtree");
            root = root.getLeftChild();
        }

        return minValue;
    }

    public static Integer maximumValue(Node<Integer> root) {
        int maxValue = Integer.MAX_VALUE;
        while (root != null) {
            maxValue = root.getData();
            System.out.println("Currently at node:" + maxValue + " going into the right subtree");
            root = root.getRightChild();
        }

        return maxValue;
    }

    public static void printRange(Node<Integer> root, int low, int high) {
        if (root == null) {
            return;
        }
        if (low <= root.getData()) {
            printRange(root.getLeftChild(), low, high);
        }
        if (low <= root.getData() && root.getData() <= high) {
            System.out.println(root.getData());
        }
        if (high > root.getData()) {
            printRange(root.getRightChild(), low, high);
        }
    }

    public static boolean isBinarySearchTree(Node<Integer> root) {
        if (root == null) {
            return true;
        }

        if (root.getLeftChild() != null) {
            if (root.getLeftChild().getData() > root.getData()) {
                return false;
            }
        }

        if (root.getRightChild() != null) {
            if (root.getRightChild().getData() <= root.getData()) {
                return false;
            }
        }

        return isBinarySearchTree(root.getLeftChild()) && isBinarySearchTree(root.getRightChild());
    }

    public static void swap(int[] list, int iIndex, int JIndex) {
        int temp = list[iIndex];
        list[iIndex] = list[JIndex];
        list[JIndex] = temp;
    }

    public static void selectionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            System.out.println();
            System.out.println("i : " + i);
            for (int j = i + 1; j < listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    swap(listToSort, i, j);
                    System.out.print("Swapping : " + i + " with " + j);

                    System.out.println(Arrays.toString(listToSort));
                }
            }
        }

    }

    public static void bubbleSort(int[] listToSort) {
        for (int i = listToSort.length - 1; i > 0; i--) {
            System.out.println();
            System.out.println("i : " + i);
            for (int j = 0; j < i; j++) {
                if (listToSort[j] > listToSort[j + 1]) {
                    swap(listToSort, j, j + 1);
                    System.out.print("Swapping : " + j + " with " + (j + 1));

                    System.out.println(Arrays.toString(listToSort));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] unsortedList = new int[]{40, 50, 60, 20, 10, 70, 100, 30, 80, 90};

        System.out.println("Unsorted List : " + Arrays.toString(unsortedList));

        bubbleSort(unsortedList);
    }
}