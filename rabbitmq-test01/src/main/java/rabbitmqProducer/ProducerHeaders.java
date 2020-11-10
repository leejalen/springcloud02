package rabbitmqProducer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.ConnectUtil;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author leejalen
 * @Description TODO headers头部交换机生产者
 * Headers-头部交换机，headers类型的交换机分发消息不依赖routingKey,是使用发送消息时basicProperties对象中的headers来匹配的。
 * Created on 2020/11/10
 */
public class ProducerHeaders {

    /**
     * 队列名称
     * */
    public final static String QUEUE_NAME = "mq.headers";

    /**
     * 交换机名
     * */
    public final static String EXCHANGE_NAME = "exchangeHeaders";

    /**
     * 路由键1
     * */
    public final static String ROUTING_KEY1 = "apple.rk1";

    public static void producer(){
        //rabbitmq连接工具类生成一条连接
        Connection connection = ConnectUtil.getConnect();

        try {
            //创建通道
            Channel channel = connection.createChannel();
            //绑定交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "headers");

            //设置消息头键值对
            Map<String, Object> header = new Hashtable<>();
            header.put("name", "lee");
            header.put("age", "18");

            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            builder.headers(header);

            String sendMessage = "我是生产者，这是经过头部交换器发出的信息";

            channel.basicPublish(EXCHANGE_NAME, "", builder.build(), sendMessage.getBytes());

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
