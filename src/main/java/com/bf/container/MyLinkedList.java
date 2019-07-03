package com.bf.container;

import java.util.LinkedList;

public class MyLinkedList<T> {

    private Node first;
    private Node last;
    private int size;

    public int size() {
        return size;
    }

    public void add(T item) {
        Node oldlast = last;
        Node node = new Node(oldlast, null, item);
        last = node;
        if (oldlast == null)
            first = last;
        else
            oldlast.next = last;
        size++;
    }

    public Node<T> get(int index) {
        return node(index);
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node<T> temp = last;
            for (int i = size - 1; i > index ; i--) {
                temp = temp.pre;
            }
            return temp;
        }
    }

    public T remove(int index) {
        Node<T> x = node(index);
        T item = x.item;
        Node<T> pre = x.pre;
        Node<T> next = x.next;
        if (pre == null) {
            first = next;
        } else {
          pre.next = next;
          x.pre = null;
        }
        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
            x.next = null;
        }
        x.item = null;
        size --;
        return item;
    }




    private class Node<T> {
        private Node pre;
        private Node next;
        private T item;

        public Node() {
        }

        public Node(Node pre, Node next, T item) {
            this.pre = pre;
            this.next = next;
            this.item = item;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.get(0);

        MyLinkedList myLinkedList = new MyLinkedList<String>();
        myLinkedList.add("a");
        myLinkedList.add("b");
        System.out.println(myLinkedList.size);
        System.out.println(myLinkedList.get(1));
    }

}