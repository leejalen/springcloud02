package rabbitmqCustomer;

import com.rabbitmq.client.*;
import utils.ConnectUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author leejalen
 * @Description TODO headers头部交换机消费者
 * Created on 2020/11/10
 */
public class CustomerHeaders {

    /**
     * 队列名称
     * */
    public final static String QUEUE_NAME = "mq.headers";

    /**
     * 交换机名
     * */
    public final static String EXCHANGE_NAME = "exchangeHeaders";

    public static void customer(){
        //rabbitmq连接工具类生成一条连接
        Connection connection = ConnectUtil.getConnect();
        System.out.println("我是消费者，开始接收消息");

        try {
            //创建通道
            Channel channel = connection.createChannel();
            //获取队列名
            String queueName = channel.queueDeclare().getQueue();
            //设置主题交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "headers");

            //设置消息头键值对
            Map<String, Object> header = new Hashtable<>();
            //匹配类型： any表示匹配任何一个键值对就行，all表示匹配所有键值对
            header.put("x-match", "all");
            header.put("name", "lee");
            header.put("age", "18");

            //绑定队列名、交换器、键值对匹配
            channel.queueBind(queueName, EXCHANGE_NAME, "", header);

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("消费端收到消息: ");
                    System.out.println("匹配类型: " + header.get("x-match"));
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
        customer();
    }
}
