package com.fangxp.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michael on 2017/1/12.
 */
public class IMDecoder extends MessageToMessageDecoder {

    //正则解析协议内容
    private Pattern pattern = Pattern.compile("^\\[(.*)\\](\\s\\-\\s(.*))?.*");

    @Override
    protected void decode(ChannelHandlerContext ctx, Object o, List list) throws Exception {

    }

    public IMMessage decode(String msg) {
        if (StringUtils.isEmpty(msg)) {
            return null;
        }
        try {
            Matcher m = pattern.matcher(msg);
            String header = "";
            String content = "";
            if (m.matches()) {
                header = m.group(1);
                content = m.group(3);
            }
            String[] headers = header.split("\\]\\[");

            //获取命令发送时间
            long time = Long.parseLong(headers[1]);
            //获取昵称
            String nickName = headers[2];
            nickName = nickName.length() < 10 ? nickName : nickName.substring(0, 9);

            String cmd = headers[0];

            //封装IMMessage对象
            if (IMP.LOGIN.getName().equals(cmd) ||
                    IMP.LOGOUT.getName().equals(cmd) ||
                    IMP.FLOWER.getName().equals(cmd)) {
                return new IMMessage(cmd, time, nickName);
            } else if (IMP.CHAT.getName().equals(cmd) ||
                    IMP.SYSTEM.getName().equals(cmd)) {
                return new IMMessage(cmd, time, nickName, content);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }


}
