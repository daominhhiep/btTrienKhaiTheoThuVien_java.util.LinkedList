public class MyLinkedList {
    private int numNodes;
    private Node head;
    private Node tail;

    public MyLinkedList(Object data) {
        head = new Node(data);
        tail = head;
        tail.next = null;
        numNodes++;
    }

    public MyLinkedList() {
    }

    public int getNumNodes() {
        return numNodes;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(int index, Object data) {
        if (index == 0) {
            addFirst(data);
        } else if (index == numNodes) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int nodeIndex = 1; nodeIndex < index; nodeIndex++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            numNodes++;
        }

    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        numNodes++;
    }

    public Node get(int index) {
        Node current = head;
        for (int indexNode = 0; indexNode < index; indexNode++) {
            current = current.next;
        }
        return current;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == numNodes) {
            removeLast();
        } else {
            Node current = head;
            for (int indexNode = 1; indexNode < index; indexNode++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        Node current = head;
        for (int indexNode = 1; indexNode < numNodes - 1; indexNode++) {
            current = current.next;
        }
        tail = current;
        tail.next = null;
    }

    public boolean removeObject(Object data) {
        if (indexOf(data) != -1) {
            remove(indexOf(data));
            return true;
        }
        return false;
    }

    public boolean isContains(Object data) {
        Node current = head;
        for (int index = 0; index < numNodes; index++) {
            if (current.getData() == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(Object data) {
        Node current = head;
        for (int index = 0; index < numNodes; index++) {
            if (current.getData() == data) {
                return index;
            }
            current = current.next;
        }
        return -1;
    }

    public Object clone() {
        MyLinkedList cloneList = new MyLinkedList();
        cloneList.head = head;
        cloneList.tail = tail;
        cloneList.numNodes += 2;
        for (int index = 1; index < numNodes - 1; index++) {
            cloneList.addLast(get(index).getData());
        }
        return cloneList;
    }
}