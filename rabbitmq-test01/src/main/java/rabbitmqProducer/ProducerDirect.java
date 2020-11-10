package rabbitmqProducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO direct直连交换机生产者
 * 直连交换机，顾名思义就是从交换机-路由键-队列三者进行绑定，然后获取准确的队列信息
 * Created on 2020/11/10
 */
public class ProducerDirect {

    /**
     * 队列名称
     * */
    public final static String QUEUE_NAME = "mqDirect";

    /**
     * 交换机名
     * */
    public final static String EXCHANGE_NAME = "exchangeDirect";

    /**
     * 路由键1
     * */
    public final static String ROUTING_KEY1 = "rk1";

    /**
     * 路由键2
     * */
    public final static String ROUTING_KEY2 = "rk2";

    public static void producer(){
        //rabbitmq连接工具类生成一条连接
        Connection connection = ConnectUtil.getConnect();
        try {
            //创建通道
            Channel channel = connection.createChannel();

            //设置直连交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            String sendMessage1 = "我是生产者，这是由交换机和路由键1绑定的队列信息(direct)";
            String sendMessage2 = "我是生产者，这是由交换机和路由键2绑定的队列信息(direct)";

            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY1, null, sendMessage1.getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY2, null, sendMessage2.getBytes());

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
