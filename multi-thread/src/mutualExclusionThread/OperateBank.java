package mutualExclusionThread;

/**
 * @author leejalen
 * @Description 多线程间的共享互斥
 * Created on 2020/12/8
 */
public class OperateBank {
    public static void main(String[] args) {
        Bank bank = new Bank(1000, "lee");
        for (int i = 0; i < 100; i++) {
            Thread saveThread = new Thread(new SaveMoneyThread(bank));
            Thread getThread = new Thread(new GetMoneyThread(bank));
            saveThread.start();
            getThread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("余额" + bank.getMoney());
    }
}

class SaveMoneyThread implements Runnable{

    private Bank bank;

    public SaveMoneyThread(Bank bank) {
        this.bank = bank;
    }

    /**
     * 存钱
     * */
    public void saveMoney(int m){
        bank.deposit(m);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"已存入" + m + "元");
    }

    @Override
    public void run() {
        saveMoney(1000);
    }
}

class GetMoneyThread implements Runnable{

    private Bank bank;

    public GetMoneyThread(Bank bank) {
        this.bank = bank;
    }

    public void getMoney(int m){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean flag = bank.withdraw(m);
        if (flag){
            System.out.println(Thread.currentThread().getName()+"已取出" + m + "元");
        } else {
            System.out.println("余额不够");
        }
    }

    @Override
    public void run() {
        getMoney(1000);
    }
}
