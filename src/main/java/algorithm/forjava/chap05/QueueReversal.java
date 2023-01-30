package algorithm.forjava.chap05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 문제 1
 */
public class QueueReversal {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(5);
        queue.offer(9);

        Queue<Integer> reverseQueue = reverseQueue(queue);
        System.out.println("reverseQueue = " + reverseQueue);
    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            stack.push(poll);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            queue.offer(pop);
        }

        return queue;
    }
}
