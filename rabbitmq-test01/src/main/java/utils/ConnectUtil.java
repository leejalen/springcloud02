package utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO rabbitMQ连接工具类
 * Created on 2020/11/10
 */
public class ConnectUtil {

    /**
     * 主机名称
     * */
    public final static String HOST = "localhost";

    /**
     * 用户名
     * */
    public final static String USERNAME = "guest";

    /**
     * 密码
     * */
    public final static String PASSWORD = "guest";

    public static Connection getConnect(){
        //创建连接工厂，生成连接对象，连接rabbitmq
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);

        Connection connection = null;
        try {
            //工厂生成一条连接
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
