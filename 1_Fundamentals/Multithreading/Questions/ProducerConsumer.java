package com.DSA.Multithreading.Questions;


/*
    Questions
        -> Blocking Queue is a queue which blocks the enqueue method if there no more capacity to hold
        -> Similarly, it blocks the deque operation if the queue is empty (nothing to deque)
        -> Queue also notifies the blocked enqueuing thread if there is some space available
        -> Also notifies the deque thread once items are available for deque

        -> Problem statement is to define such queue

    Approach
        -> First, design the basic template of the blocking queue
            -> Class with a size constructor, methods to enqueue and deque
*/
public class ProducerConsumer {

    class BlockingQueue<T> {

        T[] array;
        int size = 0;
        int capacity;
        int head = 0;
        int tail = 0;

        public BlockingQueue(int capacity) {
            this.capacity = capacity;

            // TODO: Understand the meaning of below line
            array = (T[]) new Object[capacity];
        }

        public void enqueue(T item) {

        }

        public T deque() {

        }
    }

}
