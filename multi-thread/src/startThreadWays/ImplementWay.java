package startThreadWays;

/**
 * @author leejalen
 * @Description 通过实现Runnable方法开启线程
 * Created on 2020/12/8
 */
public class ImplementWay {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ThreadImplementWay()).start();
        }
    }
}

class ThreadImplementWay implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
