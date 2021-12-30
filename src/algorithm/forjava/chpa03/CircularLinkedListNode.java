package algorithm.forjava.chpa03;

public class CircularLinkedListNode {

    private int data;
    private CircularLinkedListNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CircularLinkedListNode getNext() {
        return next;
    }

    public void setNext(CircularLinkedListNode next) {
        this.next = next;
    }

    public int getLength(CircularLinkedListNode headNode) {
        int length = 0;
        CircularLinkedListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
                break;
            }
        }
        return length;
    }

    public void printCircularNode(CircularLinkedListNode headNode) {
        CircularLinkedListNode currentNode = headNode;
        while (currentNode != null) {
            System.out.println("currentNode.getData() = " + currentNode.getData());
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
                break;
            }
        }
        System.out.println("currentNode.getData() = " + currentNode.getData());
    }

    public void insertAtEnd(CircularLinkedListNode headNode, CircularLinkedListNode nodeToInsert) {
        CircularLinkedListNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }

        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
        } else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    public void insertAtBegin(CircularLinkedListNode headNode, CircularLinkedListNode nodeToInsert) {
        CircularLinkedListNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode != null) {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
        headNode = nodeToInsert;
    }

    public void deleteAtEnd(CircularLinkedListNode headNode) {
        CircularLinkedListNode tempNode = headNode;
        CircularLinkedListNode currentNode = headNode;
        if (headNode == null) {
            System.out.println("Empty List");
            return;
        }
        while (currentNode.getNext() != headNode) {
            tempNode = currentNode;
            currentNode = currentNode.getNext();
        }
        currentNode = null;
    }
}
