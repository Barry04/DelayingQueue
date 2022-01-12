package com.wechat.wechatcode;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.UUID;

public class DelayingQueue {


    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123");

        putMSG(jedis);


//        System.out.println("========");
        PushMsg pushMsg = new PushMsg();
        pushMsg.pushMSG(jedis);
//        System.out.println("========");


    }


    public static void putMSG(Jedis jedis) {
        Msg msg0 = new Msg(UUID.randomUUID().toString(), System.currentTimeMillis() + 1006, "0");
        Msg msg1 = new Msg(UUID.randomUUID().toString(), System.currentTimeMillis() + 9000000, "1");
        Msg msg2 = new Msg(UUID.randomUUID().toString(), System.currentTimeMillis() + 5040000, "2");
        Msg msg3 = new Msg(UUID.randomUUID().toString(), System.currentTimeMillis() + 7040000, "3");
//        System.out.println("===========MSG=====");
        jedis.zadd("q", msg0.getScore(), JSON.toJSONString(msg0));
        jedis.zadd("q", msg1.getScore(), JSON.toJSONString(msg1));
        jedis.zadd("q", msg2.getScore(), JSON.toJSONString(msg2));
        jedis.zadd("q", msg3.getScore(), JSON.toJSONString(msg3));
//        System.out.println("===========MSG=====");
    }
}
