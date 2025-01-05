package com.datastructures;

public class Singleton {
    private static Singleton singletonInstance;
    private Singleton(){
    }
    public static Singleton getSingletonInstance(){
        if(singletonInstance==null){
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }
}
