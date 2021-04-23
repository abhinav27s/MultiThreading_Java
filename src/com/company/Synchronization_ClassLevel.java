/*
This is a code example showing synchronization at class level - using synchronized method.
Code under synchronized method acts as critical section with no preemption of threads.
 */
package com.company;

public class Synchronization_ClassLevel {
    public static void main(String[] args) {

        SyncClassLevel classObject = new SyncClassLevel();
        Runnable obj1 = new Runnable() {
            @Override
            public void run() {
                classObject.SyncMethod();
            }
        };
        Runnable obj2 = new Runnable() {
            @Override
            public void run() {
                classObject.SyncMethod();
            }
        };
        Thread t1 = new Thread(obj1,"Thread 1");
        Thread t2 = new Thread(obj2,"Thread 2");
        t1.start();
        t2.start();
    }
}

class SyncClassLevel{
    /* this class object acts as a shared resource for all threads */
    public synchronized void SyncMethod(){
        /* Critical Section */
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
    }
}
/*
           Sample Output:     1 1 1 2 2 or 2 2 2 1 1 1
*/