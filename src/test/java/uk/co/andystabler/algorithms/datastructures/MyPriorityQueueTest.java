package uk.co.andystabler.algorithms.datastructures;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Created by Andy Stabler on 01/06/15.
 */
@RunWith(Enclosed.class)
public class MyPriorityQueueTest {

    public static class IsEmpty {

        @Test
        public void empty_True() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            Assert.assertTrue(queue.isEmpty());
        }

        @Test
        public void notEmpty_False() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            queue.offer(4);
            queue.offer(2);
            queue.offer(1);
            Assert.assertFalse(queue.isEmpty());
        }

        @Test
        public void notEmptyPollEmpty_True() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            queue.offer(4);
            queue.poll();
            Assert.assertTrue(queue.isEmpty());
        }

        @Test
        public void notEmptyPollNotEmpty_False() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            queue.offer(4);
            queue.offer(2);
            queue.poll();
            Assert.assertFalse(queue.isEmpty());
        }
    }

    public static class Peek {

        @Test(expected = IllegalStateException.class)
        public void emptyQueue_IllegalStateException() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            queue.peek();
        }

        @Test
        public void oneElementInList_CorrectValueReturned() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            queue.offer(5);
            int value = queue.peek();
            Assert.assertEquals(5, value, 0);
        }

        @Test
        public void twoElementsInList_CorrectValueReturned() {
            MyQueue<Integer> queue = new MyPriorityQueue<>(3);
            queue.offer(5);
            queue.offer(2);
            int value = queue.peek();
            Assert.assertEquals(2, value, 0);
        }
    }

    public static class Offer {

    }

    public static class Poll {

    }

}