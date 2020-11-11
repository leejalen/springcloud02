package com.example.rabbitmq5001.utils;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
public class Constants {

    /**
     * 直连交换机名
     * */
    public final static String EXCHANGE_DIRECT = "exchangeDirect";

    /**
     * 扇形交换机名
     * */
    public final static String EXCHANGE_FANOUT = "exchangeFanout";

    /**
     * 主题交换机名
     * */
    public final static String EXCHANGE_TOPIC = "exchangeTopic";

    /**
     * 头部交换机名
     * */
    public final static String EXCHANGE_HEADERS = "exchangeHeaders";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_DIRECT = "rkDirect";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_FANOUT = "rkFanout";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_TOPIC = "rk*";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_HEADERS = "rkHeaders";

    /**
     * 队列
     * */
    public final static String QUEUE_DIRECT_A = "queueDirectA";

    /**
     * 队列
     * */
    public final static String QUEUE_DIRECT_B = "queueDirectB";

    /**
     * 队列
     * */
    public final static String QUEUE_FANOUT_C = "queueFanoutC";

    /**
     * 队列
     * */
    public final static String QUEUE_FANOUT_D = "queueFanoutD";

    /**
     * 队列
     * */
    public final static String QUEUE_TOPIC_E = "queueTopicE";

    /**
     * 队列
     * */
    public final static String QUEUE_TOPIC_F = "queueTopicF";
}
