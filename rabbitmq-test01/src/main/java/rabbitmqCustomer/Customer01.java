package rabbitmqCustomer;

import com.rabbitmq.client.*;
import utils.ConnectUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/10
 */
public class Customer01 {

    /**
     * 队列名称
     * */
    public final static String QUEUE_NAME = "mq01";

    /**
     * 交换机名
     * */
    public final static String EXCHANGE_NAME = "";

    public static void customerDemo(){
        try {
            //rabbitmq连接工具类生成一条连接
            Connection connection = ConnectUtil.getConnect();
            System.out.println("我是消费者，开始接收消息");
            //创建一条通道
            Channel channel = connection.createChannel();
            //通道申明一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, true, null);

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费端收到消息: " + message);
                }
            };
            //rabbitmq中消息确认机制
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        customerDemo();
    }
}
