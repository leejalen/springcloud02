package startThreadWays;

/**
 * @author leejalen
 * @Description 通过继承Thread类开启线程
 * Created on 2020/12/8
 */
public class ExtendWay {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ThreadExtendWay().start();
        }
    }
}

class ThreadExtendWay extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

