package com.company;

public class CreateRemoveDeadlock {
    public static void main(String[] args) {
        CommonLock lock1 = new CommonLock();
        CommonLock lock2 = new CommonLock();

        Runnable obj1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    synchronized (lock2){

                    }
                }
            }
        };
        Runnable obj2 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){ // For removal of deadlock -> swap positions of lock1 and lock 2 here i.e. in same order as in obj1
                    synchronized (lock1){

                    }
                }
            }
        };
        Thread t1=new Thread(obj1);
        Thread t2=new Thread(obj2);
        t1.start();
        t2.start();
    }
}

class CommonLock{
        int lock;
}