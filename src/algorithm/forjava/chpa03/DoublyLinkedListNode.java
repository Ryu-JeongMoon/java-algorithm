package algorithm.forjava.chpa03;

public class DoublyLinkedListNode {

    private int data;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode previous;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode previous) {
        this.previous = previous;
    }

    public int getLength(DoublyLinkedListNode headNode) {
        int length = 0;
        DoublyLinkedListNode currentNode = headNode;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }

        return length;
    }

    public DoublyLinkedListNode insertToDLL(DoublyLinkedListNode headNode, DoublyLinkedListNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }

        int size = getLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid");
            return headNode;
        }

        if (position == 1) {
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            DoublyLinkedListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previous.getNext();
                count++;
            }
            DoublyLinkedListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);

            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }

            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previous);
        }

        return headNode;
    }
}
