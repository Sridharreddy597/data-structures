package com.multithreading;

public class MyThread extends  Thread{
    MyThread(){
        System.out.print("  MyThread");
    }

    @Override
    public void run() {
        System.out.print(" bar");
    }
    public void run(String s) {
        System.out.print(" baz");
    }
}
