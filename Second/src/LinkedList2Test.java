import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


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
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void count() {
    }

    @Test
    void insertAfter() {
    }
}