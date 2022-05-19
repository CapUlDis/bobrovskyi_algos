import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node pointer = this.head;

        while (pointer != null) {
            if (pointer.value == _value) {
                return pointer;
            }

            pointer = pointer.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node pointer = this.head;

        while (pointer != null) {
            if (pointer.value == _value) {
                nodes.add(pointer);
            }

            pointer = pointer.next;
        }

        return nodes;
    }

    public boolean remove(int _value) {
        Node pointer = this.head;
        while (pointer != null) {
            if (pointer.value != _value) {
                pointer = pointer.next;
                continue;
            }

            Node prev = pointer.prev;
            Node next = pointer.next;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }

            if (prev == null) {
                this.head = next;
            }

            if (next == null) {
                this.tail = prev;
            }

            return true;
        }

        return false;
    }

    public void removeAll(int _value) {
        Node pointer = this.head;
        while (pointer != null) {
            if (pointer.value != _value) {
                pointer = pointer.next;
                continue;
            }

            Node prev = pointer.prev;
            Node next = pointer.next;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }

            if (prev == null) {
                this.head = next;
            }

            if (next == null) {
                this.tail = prev;
            }

            pointer = pointer.next;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node pointer = this.head;
        int counter = 0;
        while (pointer != null) {
            counter += 1;
            pointer = pointer.next;
        }

        return counter;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == tail) {
            addInTail(_nodeToInsert);
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            _nodeToInsert.prev = null;
            return;
        }

        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next.prev =  _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;
        _nodeAfter.next = _nodeToInsert;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}