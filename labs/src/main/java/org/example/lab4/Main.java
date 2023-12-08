package org.example.lab4;

public class Main {
    //a)	Create a thread that waits for a signal from another thread using wait and notify.
    //b)	Create your own custom class, and make an object for it. Use getDeclaredMethods() to print out all the methods of the class and their return types. Choose a specific method by name and call it using invoke(). Print out your results of invoking.
    //c)	Create a generic method that takes an instance of a class that implements a specific interface, and calls a method on that interface using interface and invoke().
    public static void main(String[] args) {
        Object lock = new Object();

        Thread waitingTread = new Thread(() ->{
            synchronized (lock) {
                System.out.println("first thread's waiting for signal");
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("1 received signal");
            }
        });

        Thread notifyThread = new Thread(() ->{
            try{
                Thread.sleep(2000); // Simulating some work
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock){
                System.out.println("second thread's notifying");
                lock.notify();
            }
        });

        waitingTread.start();
        notifyThread.start();
    }
}
