/*
This code example shows the usage of synchronization at instance level -> using synchronized block.
Code under synchronized block acts as critical section with no preemption of threads.
 */
package com.company;

public class Synchronization_InstanceLevel {
    public static void main(String[] args) {

        Thread t1 = new Thread(new SyncDemo(), "1 ");
        Thread t2 = new Thread(new SyncDemo(), "2 ");
        t1.start();
        t2.start();
    }
}
class SyncDemo implements Runnable{
    String lock="lock";
    @Override
    public void run() {
        /* lock object acts as shared resource for all threads */
        synchronized (lock) {
            /* Critical Section */
            try {
                System.out.print(Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.print(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/*
           Sample Output:     1 1 2 2 or 2 2 1 1
*/