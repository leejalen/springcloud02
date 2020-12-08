package testPackage;

/**
 * @author leejalen
 * @Description 测试多线程同步, 同步方法。
 * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码块时，
 * 在同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 一个线程访问一个对象的synchronized代码块时，别的线程可以访问该对象的非synchronized代码块而不受阻塞。
 * Created on 2020/11/24
 */
public class SyncMethod {
    public static void main(String[] args) {
        /*SyncThread syncThread = new SyncThread();
        Thread t1 = new Thread(syncThread, "A");
        Thread t2 = new Thread(syncThread, "B");
        t1.start();
        t2.start();*/

        /*SyncThread01 syncThread = new SyncThread01();
        Thread t1 = new Thread(syncThread, "A");
        Thread t2 = new Thread(syncThread, "B");
        t1.start();
        t2.start();*/


        /*SyncThread02 syncThread = new SyncThread02();
        Thread t1 = new Thread(syncThread, "A");
        Thread t2 = new Thread(syncThread, "B");
        t1.start();
        t2.start();*/

        SyncThread syncThread = new SyncThread();
        SyncThread01 syncThread01 = new SyncThread01();
        Thread t1 = new Thread(syncThread, "A");
        Thread t2 = new Thread(syncThread01, "B");
        t1.start();
        t2.start();
    }
}

class SyncThread implements Runnable{

    @Override
    public void run() {
        method();
    }

    public synchronized void method(){
        for (int i = 0; i < 5; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SyncThread01 implements Runnable{

    @Override
    public void run() {
        method();
    }

    public void method(){
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SyncThread02 implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

