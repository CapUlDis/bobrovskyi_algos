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
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
    }

    public int count() {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
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