import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class LinkedList2Test {
    LinkedList2 list = new LinkedList2();
    LinkedList2 emptyList = new LinkedList2();
    LinkedList2 sinElemList = new LinkedList2();

    Node n1 = new Node(5);
    Node n2 = new Node(7);
    Node n3 = new Node(9);
    Node n4 = new Node(5);
    Node n5 = new Node(5);
    Node n6 = new Node(3);
    Node n7 = new Node(5);

    Node n0 = new Node(33);

    @BeforeEach
    void setUp() {
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);

        sinElemList.addInTail(n0);
    }

    @AfterEach
    void reset(){
        list = new LinkedList2();
        sinElemList = new LinkedList2();
    }

    @Test
    void find() {
        Node node = list.find(5);
        assertEquals(n1, node, "List: Wrong found node");
        assertEquals(5, node.value, "List: Wrong value of found node");

        node = list.find(100);
        assertNull(node, "List: Should find null");

        node = emptyList.find(6);
        assertNull(node, "Empty list: Should find null");

        node = sinElemList.find(33);
        assertEquals(n0, node, "Single element list: Wrong found node");
        assertEquals(33, node.value, "Single element list: Wrong value of found node");
    }

    @Test
    void findAll() {
        ArrayList<Node> nodes = list.findAll(5);
        assertArrayEquals(new Node[]{n1, n4, n5, n7}, nodes.toArray(), "List: Wrong found nodes");

        nodes = list.findAll(6);
        assertEquals(0, nodes.size(), "List: Wrong found nodes");

        nodes = sinElemList.findAll(33);
        assertArrayEquals(new Node[]{n0}, nodes.toArray(), "Single element list: Wrong found nodes");

        nodes = sinElemList.findAll(6);
        assertEquals(0, nodes.size(), "Single element list: Wrong found nodes");

        nodes = emptyList.findAll(7);
        assertEquals(0, nodes.size(), "Empty list: Wrong found nodes");
    }

    @Test
    void remove() {
        assertTrue(list.remove(5), "List, remove existing node: Wrong operation return");
        assertTrue(list.remove(5), "List, remove existing node: Wrong operation return");
        assertTrue(list.remove(5), "List, remove existing node: Wrong operation return");
        assertTrue(list.remove(5), "List, remove existing node: Wrong operation return");
        assertFalse(list.remove(5), "List, remove non-existing node: Wrong operation return");

        ArrayList<Node> nodes = new ArrayList<>();
        Node pointer = list.head;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }
        assertArrayEquals(new Node[]{n2, n3, n6}, nodes.toArray(), "List, remove existing node: Wrong operation result");

        nodes = new ArrayList<>();
        pointer = list.tail;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.prev;
        }
        assertArrayEquals(new Node[]{n6, n3, n2}, nodes.toArray(), "List, remove existing node: Wrong operation result");

        assertFalse(sinElemList.remove(5), "Single element list, remove non-existing node: Wrong operation return");
        assertTrue(sinElemList.remove(33), "Single element list, remove existing node: Wrong operation return");
        assertTrue(sinElemList.head == null && sinElemList.tail == null, "Single element list, remove non-existing node: Wrong operation result");

        assertFalse(emptyList.remove(85), "Empty list, remove non-existing node: Wrong operation return");
        assertTrue(emptyList.head == null && emptyList.tail == null, "Empty list, remove non-existing node: Wrong operation result");
    }

    @Test
    void removeAll() {
        list.removeAll(5);
        ArrayList<Node> nodes = new ArrayList<>();
        Node pointer = list.head;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }
        assertArrayEquals(new Node[]{n2, n3, n6}, nodes.toArray(), "List, remove all existing node: Wrong operation result");

        nodes = new ArrayList<>();
        pointer = list.tail;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.prev;
        }
        assertArrayEquals(new Node[]{n6, n3, n2}, nodes.toArray(), "List, remove all existing node: Wrong operation result");

        list.removeAll(6);
        assertArrayEquals(new Node[]{n6, n3, n2}, nodes.toArray(), "List, remove all non-existing node: Wrong operation result");

        sinElemList.removeAll(12);
        assertTrue(sinElemList.head.value == 33 && sinElemList.tail.value == 33, "Single element list, remove all non-existing node: Wrong operation result");

        sinElemList.removeAll(33);
        assertTrue(sinElemList.head == null && sinElemList.tail == null, "Single element list, remove all existing node: Wrong operation result");

        emptyList.removeAll(85);
        assertTrue(emptyList.head == null && emptyList.tail == null, "Empty list, remove all non-existing node: Wrong operation result");
    }

    @Test
    void count() {
        assertEquals(list.count(), 7, "List, count nodes: Wrong operation result");
        assertEquals(sinElemList.count(), 1, "Single element list, count nodes: Wrong operation result");
        assertEquals(emptyList.count(), 0, "Empty list, count nodes: Wrong operation result");
    }

    @Test
    void insertAfter() {
        Node nNew1 = new Node(54);
        Node nNew2 = new Node(23);
        Node nNew3 = new Node(89);
        list.insertAfter(n3, nNew1);
        list.insertAfter(null, nNew2);
        list.insertAfter(n7, nNew3);
        assertEquals(list.count(), 10, "List, insert after node: Wrong operation result");

        ArrayList<Node> nodes = new ArrayList<>();
        Node pointer = list.tail;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.prev;
        }
        assertArrayEquals(new Node[]{nNew3, n7, n6, n5, n4, nNew1, n3, n2, n1, nNew2}, nodes.toArray(), "List, insert after node: Wrong operation result");

        nodes = new ArrayList<>();
        pointer = list.head;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }
        assertArrayEquals(new Node[]{nNew2, n1, n2, n3, nNew1, n4, n5, n6, n7, nNew3}, nodes.toArray(), "List, insert after node: Wrong operation result");

        Node nNew4 = new Node(29);
        sinElemList.insertAfter(n0, nNew4);
        assertEquals(sinElemList.count(), 2, "Single element list, insert after node: Wrong operation result");
        nodes = new ArrayList<>();
        pointer = sinElemList.head;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }
        assertArrayEquals(new Node[]{n0, nNew4}, nodes.toArray(), "Single element list, insert after node: Wrong operation result");

        Node nNew5 = new Node(3);
        sinElemList.insertAfter(null, nNew5);
        assertEquals(sinElemList.count(), 3, "Single element list, insert after node: Wrong operation result");
        nodes = new ArrayList<>();
        pointer = sinElemList.tail;
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.prev;
        }
        assertArrayEquals(new Node[]{nNew4, n0, nNew5}, nodes.toArray(), "Single element list, insert after node: Wrong operation result");

        Node nNew6 = new Node(9);
        emptyList.insertAfter(null, nNew6);
        assertEquals(emptyList.count(), 1, "Empty list, insert after node: Wrong operation result");
    }
}