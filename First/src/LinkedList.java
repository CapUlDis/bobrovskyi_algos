import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        } else {
            this.tail.next = item;
        }
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                this.head = node.next;
                return true;
            }

            if (node.next != null && node.next.value == _value) {
                node.next = node.next.next;
                if (node.next == null) {
                    this.tail = node;
                }
                return true;
            }

            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                this.head = node.next;
                node = node.next;
                continue;
            }

            if (node.next != null && node.next.value == _value) {
                node.next = node.next.next;
                if (node.next == null) {
                    this.tail = node;
                    return;
                }
                continue;
            }

            node = node.next;
        }

    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}
