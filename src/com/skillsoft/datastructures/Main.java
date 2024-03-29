package com.skillsoft.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

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

    public static void swap(String[] list, int iIndex, int JIndex) {
        String temp = list[iIndex];
        list[iIndex] = list[JIndex];
        list[JIndex] = temp;
    }

    public static void swapInt(int[] list, int iIndex, int JIndex) {
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
                    swapInt(listToSort, i, j);
                    System.out.print("Swapping : " + i + " with " + j);

                    System.out.println(Arrays.toString(listToSort));
                }
            }
        }

    }

    public static void bubbleSort(int[] listToSort) {
        for (int i = listToSort.length - 1; i > 0; i--) {
            boolean swapped = false;

            System.out.println();
            System.out.println("i : " + i);
            for (int j = 0; j < i; j++) {
                if (listToSort[j] > listToSort[j + 1]) {
                    swapInt(listToSort, j, j + 1);
                    swapped = true;
                    System.out.print("Swapping : " + j + " with " + (j + 1));

                    System.out.println(Arrays.toString(listToSort));
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void insertionSort(int[] listToSort, int increment) {
        for (int i = 0; i + increment < listToSort.length; i = i + 1) {
            System.out.println();
            System.out.println("i : " + i + " increment : " + increment);
            for (int j = i + increment; j - increment >= 0; j = j - increment) {
                if (listToSort[j] < listToSort[j - increment]) {
                    swapInt(listToSort, j, j - increment);
                    System.out.print("Swapping : " + j + " and " + (j - 1));

                    System.out.println(Arrays.toString(listToSort));
                } else {
                    break;
                }
            }
        }
    }

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2;

        while (increment >= 1) {
            insertionSort(listToSort, increment);
            increment = increment / 2;
        }
    }

    public static void split(String[] listToSort, String[] listFirstHalf, String[] listSecondHalf) {
        int secondHalfStartIndex = listFirstHalf.length;

        for (int index = 0; index < listToSort.length; index++) {
            if (index < secondHalfStartIndex) {

                listFirstHalf[index] = listToSort[index];
            } else {
                listSecondHalf[index - secondHalfStartIndex] = listToSort[index];
            }
        }
    }

    public static void merge(String[] listToSort, String[] listFirstHalf, String[] listSecondHalf) {
        int mergeIndex = 0;

        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {

            if (listFirstHalf[firstHalfIndex].compareTo(listSecondHalf[secondHalfIndex]) < 0) {

                listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else if (secondHalfIndex < listSecondHalf.length) {
                listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if (firstHalfIndex < listFirstHalf.length) {
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
            }
        }
    }

    public static void mergeSort(String[] listToSort) {
        if (listToSort.length == 1) {
            return;
        }

        int midIndex = listToSort.length / 2 + listToSort.length % 2;

        String[] listFirstHalf = new String[midIndex];
        String[] listSecondHalf = new String[listToSort.length - midIndex];

        split(listToSort, listFirstHalf, listSecondHalf);

        System.out.println();
        System.out.println("Split : " + Arrays.toString(listFirstHalf) + "     " + Arrays.toString(listSecondHalf));

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);

        merge(listToSort, listFirstHalf, listSecondHalf);

        System.out.println();
        System.out.println("Merged : " + Arrays.toString(listToSort));
    }

    public static int partition(String[] listToSort, int low, int high) {
        String pivot = listToSort[low];
        int l = low;
        int h = high;

        System.out.println();
        System.out.println("Pivit : " + pivot);

        while (l < h) {
            while (listToSort[l].compareTo(pivot) <= 0 && l < h) {
                l++;
            }

            while (listToSort[h].compareTo(pivot) > 0) {
                h--;
            }

            if (l < h) {
                swap(listToSort, l, h);

                System.out.println("Swapping" + l + " and " + h);
                System.out.println(Arrays.toString(listToSort));
            }
        }

        swap(listToSort, low, h);

        System.out.println("Swapping" + low + " and " + h);
        System.out.println(Arrays.toString(listToSort));

        System.out.println();
        System.out.println("Partitioned : " + Arrays.toString(listToSort) + "Around pivot: " + pivot);

        return h;
    }

    public static void quickSort(String[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(listToSort, low, high);

        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    public static int linearSearch(String[] listToSearch, String element) {
        System.out.println();
        System.out.print("Searching for : " + element + ": ");
        for (int i = 0; i < listToSearch.length; i++) {
            System.out.print(i + " ");
            if (listToSearch[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

//    public static int binarySearch(String[] list, String element) {
//        System.out.println();
//        System.out.print("Searching for : " + element + ": ");
//
//        int low = 0;
//        int high = list.length - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            System.out.println("Low : " + low + " High : " + high + " Mid element : " + list[mid]);
//
//            if (list[mid].equals(element)) {
//                return mid;
//            } else if (list[mid].compareTo(element) < 0) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//
//        return -1;
//    }

    public static int binarySearch(String[] list, String element, int low, int high) {
        System.out.println();
        System.out.print("Searching for : " + element + ": ");


        int mid = (low + high) / 2;
        System.out.println("Low : " + low + " High : " + high + " Mid element : " + mid);

        if (list[mid].equals(element)) {
            return mid;
        } else if (list[mid].compareTo(element) < 0) {
            return binarySearch(list, element, mid + 1, high);
        } else {
            return binarySearch(list, element, low, mid - 1);
        }
    }

    public static int jumpSearch(String[] list, String element, int jumpLength) {
        System.out.println();
        System.out.println("Searching for... " + element + ": ");

        int i = 0;
        while (list[i].compareTo(element) <= 0) {
            System.out.println("Element is greater than or equal to: " + list[i] + " ");
            i += jumpLength;
            if (i >= list.length) {
                break;
            }
        }

        int startIndex = i - jumpLength;
        int endIndex = Math.min(i, list.length);
        System.out.println("Looking between : " + startIndex + " End: " + endIndex);

        for (int j = startIndex; j < endIndex; j++) {
            if (list[j].equals(element)) {
                return j;
            }
        }

        return -1;
    }

    public static int interpolationSearch(int[] list, int element) {
        System.out.println("Searching for... " + element + ": ");

        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
//            int mid = (low + high) / 2;
            int mid = low + ((element - list[low]) * (high - low)) / (list[high] - list[low]);
            System.out.println("Low : " + low + " High : " + high + " Mid element : " + list[mid]);
            if (list[mid] == element) {
                return mid;
            } else if (list[mid] < element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }

        return (index - 1) / 2;
    }

    private static int getLeftChildIndex(int index, int endIndex) {

        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > endIndex) {
            return -1;
        }

        return leftChildIndex;
    }

    private static int getRightChildIndex(int index, int endIndex) {

        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > endIndex) {
            return -1;
        }

        return rightChildIndex;
    }

    private static void percolateDown(int[] array, int index, int endIndex) {

        System.out.println("Percolating down from index: " + array[index]);

        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);

        //Note Find the larger of the left and right child elements
        int largerIndex = -1;

        if (leftChildIndex != -1 && rightChildIndex != -1) {
            largerIndex = array[leftChildIndex] > array[rightChildIndex] ? leftChildIndex : rightChildIndex;
        } else if (leftChildIndex != -1) {
            largerIndex = leftChildIndex;

        } else if (rightChildIndex != -1) {
            largerIndex = rightChildIndex;
        }

        if (largerIndex == -1) {
            System.out.println("Stop percolating down");
            return;
        }
        if (array[largerIndex] > array[index]) {
            swapInt(array, largerIndex, index);
            System.out.println("Swap :" + Arrays.toString(array));
            percolateDown(array, index, endIndex);
        }
    }

    public static void heapify(int[] array, int endIndex) {
        int index = getParentIndex(endIndex, endIndex);

        System.out.println("Child:" + array[endIndex]);
        System.out.println("Parent:" + array[index]);

        while (index != 0) {
            System.out.println();
            System.out.println("Percolating index: " + index + " array: " + Arrays.toString(array));
            percolateDown(array, index, endIndex);
            index--;
        }
    }

    public static void heapsort(int[] array) {
        heapify(array, array.length - 1);
        System.out.println("____________________________________");

        int endIndex = array.length - 1;

        while (endIndex > 0) {
            System.out.println();
            System.out.println("End of heap: " + array[endIndex] + " array: " + Arrays.toString(array));

            System.out.println();
            System.out.println("Move " + array[0] + " to end of array");

            swapInt(array, 0, endIndex);
            System.out.println();
            System.out.println("After swap: " + Arrays.toString(array));

            endIndex--;

            percolateDown(array, 0, endIndex);
        }
    }

    public static List<Integer> sortGraph(Graph graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);

            if (indegree == 0) {
                queue.add(vertex);
            }
        }
        List<Integer> sortedList = new ArrayList<>();

        while (!queue.isEmpty()) {
//            NOTE: If more than one elemeent exists then it means that the graph has more tahn one topological sort solution.
            int vertex = queue.remove();

            // NOTE: this is the equivalent of processing the list
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);

            for (int adjacentVertex : adjacentVertices) {
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.put(adjacentVertex, updatedIndegree);

                if (updatedIndegree == 0) {
                    queue.add(adjacentVertex);
                }
            }
        }

        if (sortedList.size() != graph.getNumVertices()) {
            throw new RuntimeException("The graph had a cycle!");
        }
        return sortedList;
    }

    public static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {
        Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);

        Map<String, Integer> courseIdMap = new HashMap<>();
        Map<Integer, String> idCourseMap = new HashMap<>();

        for (int i = 0; i < courseList.size(); i++) {
            courseIdMap.put(courseList.get(i), i);
            idCourseMap.put(i, courseList.get(i));
        }

        for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
            for (String course : prereq.getValue()) {
                courseGraph.addEdge(courseIdMap.get(prereq.getKey()), courseIdMap.get(course));
            }
        }

        List<Integer> courseIdList = sortGraph(courseGraph);
        List<String> courseScheduleList = new ArrayList<>();

        for (int courseId : courseIdList) {
            courseScheduleList.add(idCourseMap.get(courseId));
        }
        return courseScheduleList;
    }


    private static Map<Integer, DistanceEntry> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceEntry> distanceTable = new HashMap<>();

        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
            }
        });

        for (int j = 0; j < graph.getNumVertices(); j++) {
            distanceTable.put(j, new DistanceEntry());
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);

        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        vertexInfoMap.put(source, sourceVertexInfo);

        while (!queue.isEmpty()) {

            VertexInfo vertexInfo = queue.poll();

            int currentVertex = vertexInfo.getVertexId();

            for (Integer neighbor : graph.getAdjacentVertices(currentVertex)) {

                // NOTE: Get the new distance, account for the weighted edge.
                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbor);

                // NOTE: If we find a new shortest path to the neighbor update the distance and the last vertex.
                if (distanceTable.get(neighbor).getDistance() > distance) {

                    distanceTable.get(neighbor).setDistance(distance);
                    distanceTable.get(neighbor).setLastVertex(currentVertex);

                    // NOTE: We have found a new short patah to the neighbor so remove the old node from the priority queue
                    VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);


                    if (neighborVertexInfo != null) {
                        queue.remove(neighborVertexInfo);
                    }

                    // NOTE: Add the neighbor back with a new updated distance.
                    neighborVertexInfo = new VertexInfo(neighbor, distance);
                    queue.add(neighborVertexInfo);
                    vertexInfoMap.put(neighbor, neighborVertexInfo);
                }
            }
        }

        return distanceTable;
    }

    public static void shortestPath(Graph graph, int source, int destination) {
        Map<Integer, DistanceEntry> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();

        while (previousVertex != -1 && previousVertex != source) {
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source + " no node: " + destination);
        } else {
            System.out.print("The shortest path is: " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println();
            System.out.println("Dijkstra DONE!");
        }
    }

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {

        Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);

        graph.addEdge(0, 3, 2);
        graph.addEdge(0, 4, 2);
        graph.addEdge(0, 1, 1);

        graph.addEdge(1, 3, 2);

        graph.addEdge(2, 7, 4);
        graph.addEdge(2, 1, 3);

        graph.addEdge(3, 6, 3);

        graph.addEdge(4, 7, 2);
        graph.addEdge(7, 5, 4);

        graph.displayGraph();
        shortestPath(graph, 0, 5);
        System.out.println("----------------------------------------------------");
    }
}
