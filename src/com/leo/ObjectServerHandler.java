package com.leo;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class ObjectServerHandler extends SimpleChannelHandler {
	 
    /**
     * �����ܵ���Ϣ��ʱ�򴥷�
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {
        Command command = (Command) e.getMessage();
        // ��ӡ�����ǲ������ǸղŴ��������Ǹ�
        System.out.println("command Action name: " + command.getActionName());
    }
}
