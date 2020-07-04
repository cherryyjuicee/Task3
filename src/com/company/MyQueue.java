package com.company;

public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length = 0;

    private class Node<T> {
        T value;
        Node<T> next;
    }

    public void add(T value) {
        Node<T> newTail = new Node<T>();
        newTail.value = value;

        if (head == null) {
            head = newTail;
            tail = newTail;
        }
        tail.next = newTail;
        tail = newTail;
        length++;
    }

    public T delete() {
        /*
        if (head == null) {
            throw new Exception(Exeption);
        }
         */
        Node<T> lastHead = head;
        if (head == tail) {
            head = null;
        } else {
            head = head.next;
        }
        length--;
        return lastHead.value;
    }

    public void createQueue (T[] array) {
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }

    public String toString() {
        String queueInString = new String();
        Node<T> node = head;
        while (node.next != null) {
            queueInString += node.value + ", ";
            node = node.next;
        }
        queueInString += node.value;
        return queueInString;
    }

    public int[] toIntArray() {
        int[] array =  new int[length];
        Node<T> node = head;
        for (int i = 0; i < length; i++) {
            array[length - 1 - i] = (int) node.value;
            node = node.next;
        }
        return array;
    }

    public void inverseQueue() {
        T[] array = (T[]) new Object[length];
        Node<T> node = head;
        for (int i = length - 1; i >= 0; i--) {
            array[i] = node.value;
            node = node.next;
        }
        head = null;
        tail = null;
        length = 0;
        this.createQueue(array);
    }
}
