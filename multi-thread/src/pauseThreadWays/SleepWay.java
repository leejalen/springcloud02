package pauseThreadWays;

/**
 * @author leejalen
 * @Description 通过sleep方法使线程暂停
 * Created on 2020/12/8
 */
public class SleepWay {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
