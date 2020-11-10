package rabbitmqProducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/10
 */
public class Producer01 {

    /**
     * 队列名称
     * */
    public final static String QUEUE_NAME = "mq01";

    /**
     * 交换机名
     * */
    public final static String EXCHANGE_NAME = "";

    public static void produceDemo(){
        try {
            //rabbitmq连接工具类生成一条连接
            Connection connection = ConnectUtil.getConnect();
            //创建一条通道
            Channel channel = connection.createChannel();
            //通道申明一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, true, null);
            //要发送的消息
            String sendMessage = "你好，我是生产者！";
            //发布信息
            channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME, null, sendMessage.getBytes());
            System.out.println("消息已发送，去消费端控制台看看");

            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        produceDemo();
    }
}
