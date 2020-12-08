package testPackage;

/**
 * @author leejalen
 * @Description 多线程同步、静态方法。
 * 静态方法是属于类的而不属于对象的。所以，synchronized修饰的静态方法锁定的是这个类的所有对象。
 * Created on 2020/11/24
 */
public class SyncStaticMethod {

    public static void main(String[] args) {
        SyncStatic syncStatic01 = new SyncStatic();
        SyncStatic syncStatic02 = new SyncStatic();
        Thread t1 = new Thread(syncStatic01, "A");
        Thread t2 = new Thread(syncStatic02, "B");
        t1.start();
        t2.start();
    }
}

class SyncStatic implements Runnable{
    private static int count;
    public synchronized static void method(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        method();
    }
}
