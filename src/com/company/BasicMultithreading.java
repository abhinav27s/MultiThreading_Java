/*
This code example shows basic usage of threads.
Concept : Irrespective of object type (same, different or anonymous), threads can run parallel in any order.
 */
package com.company;

public class BasicMultithreading {
    public static void main(String[] args) {

        // case 1 - same object obj passed
        Demo obj1 = new Demo();
        Thread t1 = new Thread(obj1, "1 ");
        Thread t2 = new Thread(obj1, "2 ");

        // case 2 - different object of same class passed (using constructor)
        Thread t3 = new Thread(new Demo(),"3 ");

        // case 3 - anonymous object passed
        Runnable obj2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.print(Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.print(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t4=new Thread(obj2,"4 ");

        // All 4 Threads can interfere in between (preemption) and can run in any order till completion
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Demo implements Runnable{

    @Override
    public void run() {
        try {
            System.out.print(Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.print(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
