package algorithm.forjava.chpa04;

import java.util.EmptyStackException;

import algorithm.forjava.chpa03.LinkedListNode;

public class LinkedListStack {

  private LinkedListNode headNode;

  public LinkedListStack() {
    this.headNode = new LinkedListNode(16);
  }

  public void push(int data) {
    if (headNode == null) {
      headNode = new LinkedListNode(data);
    } else {
      LinkedListNode linkedListNode = new LinkedListNode(data);
      linkedListNode.setNext(headNode);
      headNode = linkedListNode;
    }
  }

  public int top() {
    return headNode.getData();
  }

  public int pop() {
    if (headNode == null) {
      throw new EmptyStackException();
    } else {
      int data = headNode.getData();
      headNode = headNode.getNext();
      return data;
    }
  }

  public boolean isEmpty() {
    return headNode == null;
  }

  public void delete() {
    headNode = null;
  }
}
