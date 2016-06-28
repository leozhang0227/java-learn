package com.leo;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class ObjectServerHandler extends SimpleChannelHandler {
	 
    /**
     * 当接受到消息的时候触发
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {
        Command command = (Command) e.getMessage();
        // 打印看看是不是我们刚才传过来的那个
        System.out.println("command Action name: " + command.getActionName());
    }
}
