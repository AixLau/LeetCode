package com.linkedlist;

public class _707 {
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    Node head;
    Node tail;

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node cur;
        if (index < size >> 1) {
            cur = head;
            for (int i = 0; i < index + 1; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = index + 1; i > 0; i--) {
                cur = cur.prev;
            }
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        Node cur;
        if (index < size >> 1) {
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = index; i >= 0; i--) {
                cur = cur.prev;
            }
        }
        Node node = new Node(val);
        Node next = cur.next;
        cur.next = node;
        node.prev =cur;
        node.next = next;
        next.prev = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size) {
            return;
        }
        index = Math.max(0, index);
        Node pred,succ;
        if (index < size >> 1) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ =pred.next;
        } else {
            succ = tail;
            for (int i = index; i >= 0; i--) {
                succ = succ.prev;
            }
            pred=succ.prev;
        }
        pred.next = succ;
        succ.prev = pred;
        size--;
    }
}