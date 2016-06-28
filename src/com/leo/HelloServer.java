package com.leo;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

public class HelloServer {

	public static void main(String args[]) {
		// Server����������
		ServerBootstrap bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		// ����һ������ͻ�����Ϣ�͸�����Ϣ�¼�����(Handler)
		/*bootstrap
				.setPipelineFactory(new ChannelPipelineFactory() {
					@Override
					public ChannelPipeline getPipeline()
							throws Exception {
						return Channels
								.pipeline(new HelloServerHandler());
					}
				});*/
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
		    @Override
		    public ChannelPipeline getPipeline()throws Exception {
		        return Channels.pipeline(
		        new ObjectDecoder(ClassResolvers.cacheDisabled(this
		                .getClass().getClassLoader())),
		        new ObjectServerHandler());
		    }
		}); 
		// ����8000�˿ڹ��ͻ��˷��ʡ�
		bootstrap.bind(new InetSocketAddress(8000));
	}

	private static class HelloServerHandler extends
			SimpleChannelHandler {

		/**
		 * ���пͻ��˰󶨵�����˵�ʱ�򴥷�����ӡ"Hello world, I'm server."
		 * 
		 * @alia OneCoder
		 * @author lihzh
		 */
		@Override
		public void channelConnected(
				ChannelHandlerContext ctx,
				ChannelStateEvent e) {
			System.out.println("Hello world, I'm server.");
		}
	}
}