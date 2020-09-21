package com.leetcode.l1115;

public class FooBar {
    private int n;
    private int cnt = 1;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (cnt%2!=1){
                    wait();
                }
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            synchronized (this){
                cnt++;
                notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (cnt%2!=0){
                    wait();
                }
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            synchronized (this){
                cnt++;
                notifyAll();
            }

        }
    }
}
