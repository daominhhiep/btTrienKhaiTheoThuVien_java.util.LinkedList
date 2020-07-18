import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTestNew {
    MyLinkedList myLinkedList;

    @BeforeEach
    void newObj() {
        myLinkedList = new MyLinkedList(10);
    }

    @Test
    void getNumNodes() {
        int expectedNode = 1;
        int actualNode = myLinkedList.getNumNodes();
        assertEquals(expectedNode, actualNode);
    }

    @Test
    void getHead() {
        int headData = 10;
        int actualData = (int) myLinkedList.getHead().getData();
        assertEquals(headData, actualData);
    }

    @Test
    void add() {
        myLinkedList.add(1, 11);
        myLinkedList.add(2, 12);
        myLinkedList.add(3, 13);
        System.out.println("Sequence add: ");
        myLinkedList.printList();
        String dataAdd = "b";
        int indexAdd = 2;
        myLinkedList.add(indexAdd, dataAdd);
        System.out.println("Radom add: ");
        myLinkedList.printList();
        int expectedNode = 5;
        int actualNode = myLinkedList.getNumNodes();
        assertEquals(expectedNode, actualNode);
        assertEquals(dataAdd, myLinkedList.get(indexAdd).getData());
    }

    @Test
    void addFirst() {
        System.out.println("Before add: ");
        myLinkedList.printList();
        int dataAddHead = 9;
        myLinkedList.addFirst(dataAddHead);
        System.out.println("After add: ");
        myLinkedList.printList();
        assertEquals(dataAddHead, myLinkedList.getHead().getData());
    }

    @Test
    void addLast() {
        System.out.println("Before add: ");
        myLinkedList.printList();
        int dataAddTail = 9;
        myLinkedList.addLast(dataAddTail);
        System.out.println("After add: ");
        myLinkedList.printList();
        assertEquals(dataAddTail, myLinkedList.getTail().getData());
    }

    @Test
    void get() {
        assertEquals(10, myLinkedList.get(0).getData());
    }

    @Test
    void remove() {
        myLinkedList.addFirst(9);
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        System.out.println("Before remove: ");
        myLinkedList.printList();
        int expectedData = (int) myLinkedList.get(3).getData();
        myLinkedList.remove(2);
        assertEquals(expectedData,myLinkedList.get(2).getData());
        System.out.println("After remove: ");
        myLinkedList.printList();
    }

    @Test
    void removeFirst() {
        myLinkedList.addFirst(9);
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        System.out.println("Before remove: ");
        myLinkedList.printList();
        int expectedData = (int) myLinkedList.get(1).getData();
        myLinkedList.removeFirst();
        assertEquals(expectedData,myLinkedList.getHead().getData());
        System.out.println("After remove: ");
        myLinkedList.printList();
    }

    @Test
    void removeLast() {
        myLinkedList.addFirst(9);
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        System.out.println("Before remove: ");
        myLinkedList.printList();
        int expectedData = (int) myLinkedList.get(2).getData();
        myLinkedList.removeLast();
        assertEquals(expectedData,myLinkedList.getTail().getData());
        System.out.println("After remove: ");
        myLinkedList.printList();
    }

    @Test
    void contains() {
        myLinkedList.addFirst(9);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(7);
        myLinkedList.printList();
        assertEquals(true,myLinkedList.isContains(8));
        assertEquals(false,myLinkedList.isContains(13));
    }

    @Test
    void removeObject() {
        myLinkedList.addFirst(9);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(7);
        System.out.println("Before Remove");
        myLinkedList.printList();
        assertEquals(true,myLinkedList.removeObject(8));
        System.out.println("After Remove");
        myLinkedList.printList();
    }

    @Test
    void indexOf() {
        myLinkedList.addFirst(9);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(7);
        myLinkedList.printList();
        assertEquals(2,myLinkedList.indexOf(9));
    }

    @Test
    void cloneList() {
        myLinkedList.addFirst(9);
        myLinkedList.addFirst(8);
        myLinkedList.addFirst(7);
        int expectedSize = myLinkedList.getNumNodes();
        System.out.println("Original: ");
        myLinkedList.printList();
        MyLinkedList cloneList;
        cloneList = (MyLinkedList) myLinkedList.clone();
        System.out.println("Clone: ");
        cloneList.printList();
        assertEquals(expectedSize,cloneList.getNumNodes());
        for (int index = 0; index < cloneList.getNumNodes(); index++) {
            assertEquals(myLinkedList.get(index).getData(),cloneList.get(index).getData());
        }
    }
}