package com.multithreading;

import java.util.ArrayList;

class ThreadA {

    public static void main(String [] args) {
        ThreadB b = new ThreadB();
        b.start();
        synchronized(b) {
            System.out.println("synchronised thread name is : "+Thread.currentThread().getName());

            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {}
            System.out.println("Total is: "+Thread.currentThread().getName() + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;

    public void run() {
        System.out.println("run thread name is : "+Thread.currentThread().getName());

        synchronized(this) {
            for(int i = 0; i < 100; i++) {
                total += i;
            }
            notify();
        }
    }
}

class TestMultiPriority1 extends Thread {

    public void run() {
        System.out.println("Running thread name is:" + Thread.currentThread().getName()+" Running thread priority is:" + Thread.currentThread().getPriority());
    }

    public static void main(String args[]) {
        TestMultiPriority1 m1 = new TestMultiPriority1();
        TestMultiPriority1 m2 = new TestMultiPriority1();
        m1.setPriority(Thread.MIN_PRIORITY);
        m2.setPriority(Thread.MAX_PRIORITY);
        m1.start();
        m2.start();
        System.out.println("Running thread name is:" + Thread.currentThread().getName());

    }
}

//Dead lock...........
class HelloClass {
    public synchronized void first(HiClass hi) {
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ie) {}
        System.out.println(" HelloClass is calling 	HiClass second() method");
        hi.second();
    }
    public synchronized void second() {
        System.out.println("I am inside second method of HelloClass");
    }
}

class HiClass {
    public synchronized void first(HelloClass he) {
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){}
        System.out.println(" HiClass is calling HelloClass second() method");
        he.second();
    }
    public synchronized void second() {
        System.out.println("I am inside second method of HiClass");
    }
}

class DeadlockClass extends Thread {
    HelloClass he = new HelloClass();
    HiClass hi = new HiClass();
    public void demo() {
        this.start();
        he.first(hi);
    }
    public void run() {
        hi.first(he);
    }

    public static void main(String[] args) {
        DeadlockClass dc = new DeadlockClass();
        dc.demo();
    }
}
/**
 * This program is used to show the multithreading
 * example with synchronization using static synchronized method.
 * @author codesjava
 */
class PrintTable {
    public synchronized static void printTable(int n) {
        System.out.println("Table of " + n);
        for(int i = 1; i <= 10; i++) {
            System.out.println(n*i);
            try {
                Thread.sleep(500);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    public void run() {
        PrintTable.printTable(2);
    }
}

class MyThread2 extends Thread {
    public void run() {
        PrintTable.printTable(5);
    }
}

class MultiThreadExample1 {
    public static void main(String args[]) {

        //creating threads.
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        //start threads.
        t1.start();
        t2.start();
    }
}

class Test{

    static int start = 2;
    final int end;
    public Test(int x) {
        x = 4;
        end = x;
    }
    public void fly(int distance) {
        System.out.println(end-start+" ");
        System.out.println(distance);
    }
    public static void main(String []args){
        new Test(10).fly(5);
        int num = 99_9;
        System.out.println(num);
    }
}
