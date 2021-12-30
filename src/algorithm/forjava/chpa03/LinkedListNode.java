package algorithm.forjava.chpa03;

public class LinkedListNode {

    private int data;
    private LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public int getLength(LinkedListNode headNode) {
        int length = 0;
        LinkedListNode currentNode = headNode;

        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }

        return length;
    }

    public LinkedListNode insert(LinkedListNode headNode, LinkedListNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }

        int size = getLength(headNode);

        // 삽입할 위치가 올바르지 않으면 에러, headNode 반환
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid");
            return headNode;
        }

        // 머리 노드에 삽입해야한다면 setNext 로 이전 headNode 넣고 자신이 headNode 됨
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            LinkedListNode previousNode = headNode;
            int count = 1;

            // previousNode 삽입할 위치 바로 전 노드
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }

            // 삽입할 노드 다음 노드가 currentNode
            LinkedListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    public LinkedListNode delete(LinkedListNode headNode, int position) {
        int size = getLength(headNode);

        if (position > size || position < 1) {
            System.out.println("Position of node to insert is invalid");
            return headNode;
        }

        if (position == 1) {
            LinkedListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else {
            LinkedListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            LinkedListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }
}
