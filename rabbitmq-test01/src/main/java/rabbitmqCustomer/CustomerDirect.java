package rabbitmqCustomer;

import com.rabbitmq.client.*;
import utils.ConnectUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author leejalen
 * @Description TODO direct直连交换机消费者
 * Created on 2020/11/10
 */
public class CustomerDirect {

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

    public static void consumer(){
        //rabbitmq连接工具类生成一条连接
        Connection connection = ConnectUtil.getConnect();
        System.out.println("我是消费者，开始接收消息");
        try {
            //创建通道
            Channel channel = connection.createChannel();
            //获取队列名
            String queueName = channel.queueDeclare().getQueue();
            //设置直连交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            //绑定队列名、交换器、路由键
            channel.queueBind(queueName, EXCHANGE_NAME, ROUTING_KEY1);
            channel.queueBind(queueName, EXCHANGE_NAME, ROUTING_KEY2);

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费端收到消息: ");
                    System.out.println("路由键: " + envelope.getRoutingKey());
                    System.out.println("消息内容: " + message);
                }
            };
            //rabbitmq中消息确认机制
            channel.basicConsume(queueName, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        consumer();
    }
}
