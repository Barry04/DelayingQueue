package com.wechat.wechatcode;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class PushMsg {


    public void pushMSG(Jedis jedis) {

        System.out.println("=========pushMSG=======");
        System.out.println("q nums: " + jedis.zcard("q"));
        // 当前时间
        long now = System.currentTimeMillis();
        // 删除过期的消息
        jedis.zremrangeByScore("q", 0, now);
		// 获取未过期的信息
        Set<String> values = jedis.zrevrange("q", 0, -1 );
        System.out.println(values.size());
        System.out.println("未发布的消息：");
        for (String v:  values
             ) {
            System.out.println(v);
        }
        System.out.println("=========pushMSG=======");
    }
}





