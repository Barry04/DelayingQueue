package com.wechat.wechatcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Msg {

    private String id;

    private double score;

    private String msg;

}
