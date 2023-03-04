package com.DSA.InterviewQuestions;

public class CashFree {

/*
    Implement a custom deque using array
    -> push(), pop() from rear and front
    -> front() and back()
        -> For front and last element


    -> print entire deque ***


    Approach
        -> need to keep track of front and last
        -> Push
            -> Front
            -> Back
*/

    /*

    class MyDeque {

        int size;
        int[] arr;

        MyDeque(int size) {

            if(size == 0) {

                System.out.println("Cannot form Deque");
            }

            this.size = size;
            this.arr = new int[size];

            for(int i = 0; i<size; i++) {

                arr[i] = -1;
            }
        }

        int frontIndex = 0;
        int lastIndex = 1;
        int numOfElems = 0;

        void push_front(int val) {

            if(numOfElems < size) {

                arr[frontIndex] = val;

                if(frontIndex == 0) {
                    frontIndex = size-1;
                }
                else {
                    // TODO: Validation that this below index will not collide with lastIndex's value
                    frontIndex-=1;
                }

                numOfElems+=1;
            }
            else {
                System.out.println("Limit Exhausted");
            }
        }

        void push_back(int val) {

            if(numOfElems < size) {

                arr[lastIndex] = val;

                if(lastIndex < size -1) {
                    lastIndex+=1;
                }
                else if(lastIndex == size -1) {

                    if(arr[0] == -1) {
                        lastIndex = 0;

                        if(frontIndex == 0) {
                            frontIndex+=1;

                            // But we start lastIndex from 1, so if this happens, array is full
                            numOfElems+=1;
                            return;
                        }
                    }
                    else {
                        System.out.println("Collision with frontIndex()");
                    }
                }

                numOfElems+=1;
            }
            else {
                System.out.println("Limit Exhausted");
            }
        }

        int pop_front() {

            int returnVal;
            if(frontIndex == size - 1) {
                returnVal = arr[0];
                arr[0] = -1;
                frontIndex = 0;
                numOfElems-=1;
                System.out.println("Removed " + returnVal + " from queue front");
                return returnVal;
            }

            returnVal = arr[frontIndex+1];
            arr[frontIndex+1] = -1;
            frontIndex+=1;

            numOfElems-=1;
            System.out.println("Removed " + returnVal + " from queue front");

            return returnVal;

        }

        int pop_back() {

            int returnVal;
            if(lastIndex == 0) {
                returnVal = arr[size-1];
                arr[size-1] = -1;
                lastIndex = size-1;
                numOfElems-=1;
                System.out.println("Removed " + returnVal + " from queue back");
                return returnVal;
            }

            returnVal = arr[lastIndex-1];
            arr[lastIndex-1] = -1;
            lastIndex-=1;

            numOfElems-=1;
            System.out.println("Removed " + returnVal + " from queue back");

            return returnVal;

        }

        int front() {

            if(frontIndex == size - 1) {
                return arr[0];
            }

            return arr[frontIndex+1];
        }

        int back() {

            if(lastIndex == 0) {
                return arr[size - 1];
            }

            return arr[lastIndex - 1];
        }

        public int[] getArr() {

            return this.arr;
        }

    }


    public class Solution {




        public static void main(String args[] ) throws Exception {
            // Scanner in = new Scanner(System.in);
            // int num1, num2, sum;
            // num1 = in.nextInt();
            // num2 = in.nextInt();

            // sum = addNumbers(num1, num2);
            // System.out.println("The sum is " + sum);

            MyDeque deque = new MyDeque(5);



            deque.push_front(10);
            deque.push_front(20);
            deque.push_front(30);
            deque.push_front(40);
            deque.push_front(50);
            deque.pop_back();
            deque.pop_back();
            deque.pop_back();
            deque.pop_back();
            deque.pop_back();
            deque.pop_back();
            deque.pop_back();

            System.out.println(deque.front());
            System.out.println(deque.back());



            //  for(int x: deque.getArr()) {

            //     System.out.println(x);
            // }

            System.out.println("********\n\n");

            deque.push_back(25);
            System.out.println(deque.front());
            System.out.println(deque.back());

            // for(int x: deque.getArr()) {

            //     System.out.println(x);
            // }
            System.out.println("********\n\n");

            deque.push_front(35);
            System.out.println(deque.front());
            System.out.println(deque.back());

            //  for(int x: deque.getArr()) {

            //     System.out.println(x);
            // }
            System.out.println("********\n\n");

            deque.pop_back();
            System.out.println(deque.front());
            System.out.println(deque.back());

            // for(int x: deque.getArr()) {

            //     System.out.println(x);
            // }
            System.out.println("********\n\n");

            deque.pop_front();
            System.out.println(deque.front());
            System.out.println(deque.back());
            //  for(int x: deque.getArr()) {

            //     System.out.println(x);
            // }

            System.out.println("********\n\n");




        }
    }


     */
}
