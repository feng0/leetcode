package com.leetcode.l1114;

public class Foo {
    private volatile int a = 0;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        synchronized (this){
            a = 1;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this){
            if(a!=1){
                wait();
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        synchronized (this){
            a=2;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this){
            while(a!=2){
                wait();
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
