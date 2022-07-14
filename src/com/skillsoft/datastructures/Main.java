package com.skillsoft.datastructures;

public class Main {
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

        c.setLeftChild(d);
        c.setRightChild(e);


        d.setLeftChild(f);
        d.setRightChild(h);

        e.setRightChild(g);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }
}