package mutualExclusionThread;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/8
 */
public class Bank {

    private int money;
    private String name;

    public Bank(int money, String name) {
        this.money = money;
        this.name = name;
    }

    /**
     * 存款
     * */
    public synchronized void deposit(int m){
        money += m;
    }

    public synchronized boolean withdraw(int m){
        if (money >= m){
            money -= m;
            return true;
        } else {
            return false;
        }
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
