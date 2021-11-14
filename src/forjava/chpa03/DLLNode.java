package forjava.chpa03;

public class DLLNode {

    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public int getLength(DLLNode headNode) {
        int length = 0;
        DLLNode currentNode = headNode;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }

        return length;
    }

    public DLLNode insertToDLL(DLLNode headNode, DLLNode nodeToInsert, int position) {
        if (headNode == null)
            return nodeToInsert;

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
            DLLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previous.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);

            if(currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }

            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previous);
        }

        return headNode;
    }
}
