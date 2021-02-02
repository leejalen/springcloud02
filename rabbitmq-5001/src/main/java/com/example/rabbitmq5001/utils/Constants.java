package com.example.rabbitmq5001.utils;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
public class Constants {

    /*交换机-----------------------------------------------------------------------*/
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

    /*路由键-----------------------------------------------------------------------*/

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY = "rk";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_DIRECT_1 = "rkDirect1";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_DIRECT_2 = "rkDirect2";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_FANOUT = "rkFanout";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_TOPIC = "rk.*";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_TOPIC_1 = "rk.1";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_TOPIC_2 = "rk.2";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_TOPIC_NO = "No";

    /**
     * 路由键
     * */
    public final static String ROUTING_KEY_HEADERS = "rkHeaders";

    /*消息队列-----------------------------------------------------------------------*/

    /**
     * 队列
     * */
    public final static String QUEUE = "queue";

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

    /**
     * 队列
     * */
    public final static String QUEUE_TOPIC_G = "queueTopicG";
}
