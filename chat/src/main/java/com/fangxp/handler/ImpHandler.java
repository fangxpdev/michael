package com.fangxp.handler;

import com.fangxp.protocol.IMMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 处理自定义协议的逻辑
 * @author fangxp
 *
 */
public class ImpHandler extends SimpleChannelInboundHandler<IMMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, IMMessage msg) throws Exception {
		
	}

}
