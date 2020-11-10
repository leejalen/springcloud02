package rabbitmqProducer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO fanout扇形交换机生产者
 * fanout类型交换机会将接收到的消息广播给所有与之绑定的队列，也就是和路由键没有很大关系了
 * Created on 2020/11/10
 */
public class ProducerFanout {

    /**
     * 交换机名1
     * */
    public final static String EXCHANGE_NAME1 = "exchangeFanout1";

    /**
     * 交换机名2
     * */
    public final static String EXCHANGE_NAME2 = "exchangeFanout2";

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
            //绑定扇形交换机1
            channel.exchangeDeclare(EXCHANGE_NAME1, "fanout");
            String sendMessage1 = "我是生产者，这是由交换机1和路由键1绑定的队列信息(fanout)";
            String sendMessage2 = "我是生产者，这是由交换机1和路由键2绑定的队列信息(fanout)";

            channel.basicPublish(EXCHANGE_NAME1, ROUTING_KEY1, null, sendMessage1.getBytes());
            channel.basicPublish(EXCHANGE_NAME1, ROUTING_KEY2, null, sendMessage2.getBytes());

            //绑定扇形交换机1
            channel.exchangeDeclare(EXCHANGE_NAME2, "fanout");
            String sendMessage3 = "我是生产者，这是由交换机2和路由键1绑定的队列信息(fanout)";
            String sendMessage4 = "我是生产者，这是由交换机2和路由键2绑定的队列信息(fanout)";

            channel.basicPublish(EXCHANGE_NAME2, ROUTING_KEY1, null, sendMessage3.getBytes());
            channel.basicPublish(EXCHANGE_NAME2, ROUTING_KEY2, null, sendMessage4.getBytes());

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
