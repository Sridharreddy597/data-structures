package com.codinginterview.ice;

public class Solution {

    public static void main(String args[]) throws InterruptedException{
        Object resource1 = new Object();
        Object resource2 = new Object();
        Thread th1 =  new ThreadWithResources("Th-1", resource1, resource2);
        Thread th2 =  new ThreadWithResources("Th-2", resource2, resource1);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("Done");
    }

}

class ThreadWithResources extends Thread{
    private Object resource1, resource2;
    public ThreadWithResources(String name, Object resource1, Object resource2){
        super(name);
        this.resource1= resource1;
        this.resource2= resource2;
    }
    @Override
    public void run(){
        Object o1,o2= null;
        if(resource1.hashCode()<resource2.hashCode()){
            o1=resource1;
        }else{
            o1=resource2;
        }
        if(resource2.hashCode()<resource1.hashCode()){
            o2=resource2;
        }else{
            o2=resource1;
        }
        synchronized (o1){
            System.out.println(Thread.currentThread().getName()+"locked resource "+resource1.hashCode());
            try {
                Thread.sleep(15);
            } catch (InterruptedException e){
            }
            System.out.println(Thread.currentThread().getName()+" waiting to lock resource"+resource2.hashCode());
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"locked resource"+resource2.hashCode());
            }
        }
    }
}
