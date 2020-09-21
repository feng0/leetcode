package com.leetcode.l1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

//    private int zeroCnt = 0;
//    private int evenOddCnt = 1;
    private boolean zeroflag = false;
    private boolean flag = false;
    private boolean evenFlag = false;
    private boolean oddFlag = false;

    private Object lock = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        synchronized (lock) {
            for(int i=0;i<n;i++){
                while (zeroflag) {
                    lock.wait();
                }
                printNumber.accept(0);
                zeroflag=true;
                if(!flag){
                    oddFlag=true;
                }else{
                    evenFlag= true;
                }
                lock.notifyAll();

            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        synchronized (lock) {
            for(int i=0;i<n;i++){
                while (!evenFlag) {
                    lock.wait();
                }
                printNumber.accept(2*i + 2);
                evenFlag=false;
                zeroflag=false;
                flag=false;
                lock.notifyAll();

            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            for(int i=0;i<n;i++){

                while (!oddFlag) {
                    lock.wait();
                }
                printNumber.accept(2*i + 1);
                zeroflag = false;
                oddFlag = false;
                flag = true;
                lock.notifyAll();
            }
        }

    }
}
