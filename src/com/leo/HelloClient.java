package com.leo;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ChildChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Netty 客户端代码
 * 
 * @author lihzh
 * @alia OneCoder
 * @blog http://www.coderli.com
 */
public class HelloClient {

	public static void main(String args[]) {
		// Client服务启动器
		ClientBootstrap bootstrap = new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		// 设置一个处理服务端消息和各种消息事件的类(Handler)
		/*bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(new HelloClientHandler());
			}
		});*/
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
		    @Override
		    public ChannelPipeline getPipeline()throws Exception {
		        return Channels.pipeline(new ObjectEncoder(),
		                new ObjectClientHandler());
		    }
		});
		// 连接到本地的8000端口的服务端
		bootstrap.connect(new InetSocketAddress(
				"127.0.0.1", 8000));
	}

	private static class HelloClientHandler extends SimpleChannelHandler {


		/**
		 * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
		 * 
		 * @alia OneCoder
		 * @author lihzh
		 */
		@Override
		public void channelConnected(ChannelHandlerContext ctx,
				ChannelStateEvent e) {
			System.out.println("Hello world, I'm client.");
		}

		@Override
		public void bindRequested(ChannelHandlerContext ctx, ChannelStateEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.bindRequested(ctx, e);
		}

		@Override
		public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.channelBound(ctx, e);
		}

		@Override
		public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.channelClosed(ctx, e);
		}

		@Override
		public void channelDisconnected(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.channelDisconnected(ctx, e);
		}

		@Override
		public void channelInterestChanged(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.channelInterestChanged(ctx, e);
		}

		@Override
		public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.channelOpen(ctx, e);
		}

		@Override
		public void channelUnbound(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.channelUnbound(ctx, e);
		}

		@Override
		public void childChannelClosed(ChannelHandlerContext ctx,
				ChildChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.childChannelClosed(ctx, e);
		}

		@Override
		public void childChannelOpen(ChannelHandlerContext ctx,
				ChildChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.childChannelOpen(ctx, e);
		}

		@Override
		public void closeRequested(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.closeRequested(ctx, e);
		}

		@Override
		public void connectRequested(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.connectRequested(ctx, e);
		}

		@Override
		public void disconnectRequested(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.disconnectRequested(ctx, e);
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.exceptionCaught(ctx, e);
		}

		@Override
		public void handleDownstream(ChannelHandlerContext arg0,
				ChannelEvent arg1) throws Exception {
			// TODO Auto-generated method stub
			super.handleDownstream(arg0, arg1);
		}

		@Override
		public void handleUpstream(ChannelHandlerContext arg0, ChannelEvent arg1)
				throws Exception {
			// TODO Auto-generated method stub
			super.handleUpstream(arg0, arg1);
		}

		@Override
		public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.messageReceived(ctx, e);
		}

		@Override
		public void setInterestOpsRequested(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.setInterestOpsRequested(ctx, e);
		}

		@Override
		public void unbindRequested(ChannelHandlerContext ctx,
				ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.unbindRequested(ctx, e);
		}

		@Override
		public void writeComplete(ChannelHandlerContext ctx,
				WriteCompletionEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.writeComplete(ctx, e);
		}

		@Override
		public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
				throws Exception {
			// TODO Auto-generated method stub
			super.writeRequested(ctx, e);
		}		
		
	}
}