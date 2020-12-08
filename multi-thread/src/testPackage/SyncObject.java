package testPackage;

/**
 * @author leejalen
 * @Description 测试多线程同步，同步对象。
 * Created on 2020/11/24
 */
public class SyncObject {
    public static void main(String[] args) {
        Account account = new Account("lee", 10000);
        AccountOperate accountOperate = new AccountOperate(account);
        AccountOperate accountOperate01 = new AccountOperate(account);
        Thread[] threads = new Thread[5];
        for (int i = 1; i < 5; i++) {
            if (i % 2 == 0){
                threads[i] = new Thread(accountOperate, "Thread" + i);
            } else {
                threads[i] = new Thread(accountOperate, "Thread" + i);
            }
            threads[i].start();
        }
    }
}

class AccountOperate implements Runnable{
    private Account account;

    public AccountOperate(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
       synchronized (account){
           account.save(1000);
           account.get(1000);
           System.out.println(Thread.currentThread().getName()+ ":" + account.getBalance());
       }
    }
}

class Account{
    private String name;
    private float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    //存钱
    public void save(float amt){
        amount += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //取钱
    public void get(float amt){
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getBalance(){
        String info = name + ":" + amount;
        return info;
    }
}
