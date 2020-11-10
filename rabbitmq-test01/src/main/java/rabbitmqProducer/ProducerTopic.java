package rabbitmqProducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO topic主题交换机生产者
 * Created on 2020/11/10
 */
public class ProducerTopic {

    /**
     * 交换机名
     * */
    public final static String EXCHANGE_NAME = "exchangeTopic";

    /**
     * 路由键1
     * */
    public final static String ROUTING_KEY1 = "apple.rk1";

    /**
     * 路由键2
     * */
    public final static String ROUTING_KEY2 = "apple.rk2";

    /**
     * 路由键1
     * */
    public final static String ROUTING_KEY3 = "banana.rk1";

    /**
     * 路由键2
     * */
    public final static String ROUTING_KEY4 = "banana.rk2";

    public static void producer(){
        //rabbitmq连接工具类生成一条连接
        Connection connection = ConnectUtil.getConnect();
        try {
            //创建通道
            Channel channel = connection.createChannel();
            //绑定扇形交换机1
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            String sendMessage1 = "我是生产者，这是由交换机和路由键" + ROUTING_KEY1 + "绑定的队列信息(topic)";
            String sendMessage2 = "我是生产者，这是由交换机和路由键" + ROUTING_KEY2 + "绑定的队列信息(topic)";
            String sendMessage3 = "我是生产者，这是由交换机和路由键" + ROUTING_KEY3 + "绑定的队列信息(topic)";
            String sendMessage4 = "我是生产者，这是由交换机和路由键" + ROUTING_KEY4 + "绑定的队列信息(topic)";

            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY1, null, sendMessage1.getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, null, sendMessage2.getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY3, null, sendMessage3.getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY4, null, sendMessage4.getBytes());

            channel.close();
            connection.close();

            System.out.println("生产者消息发送完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        producer();
    }
}
