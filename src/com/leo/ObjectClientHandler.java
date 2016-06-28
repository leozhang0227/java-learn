package com.leo;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class ObjectClientHandler extends SimpleChannelHandler {
	 
    /**
     * ���󶨵�����˵�ʱ�򴥷���������˷���Ϣ��
     *
     * @author lihzh
     * @alia OneCoder
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        // �����˷���Object��Ϣ
        sendObject(e.getChannel());
    }
 
    /**
     * ����Object
     *
     * @param channel
     * @author lihzh
     * @alia OneCoder
     */
    private void sendObject(Channel channel) {
        Command command =new Command();
        command.setActionName("Hello action.");
        channel.write(command);
    }
 
}
