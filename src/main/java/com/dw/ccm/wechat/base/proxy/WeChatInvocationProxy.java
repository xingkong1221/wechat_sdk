package com.dw.ccm.wechat.base.proxy;

import com.dw.ccm.wechat.base.ResponseInterceptor;
import com.dw.ccm.wechat.base.WeChat;
import com.dw.ccm.wechat.base.exception.WechatExceptionCode;
import com.dw.ccm.wechat.base.message.response.BaseResponse;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 微信公众平台基础框架功能封装接口动态代理类
 * 
 * <p>主要用于检查接口调用是否成功
 * 
 * @author xingkong1221
 * @date 2014年6月23日
 */
public class WeChatInvocationProxy implements InvocationHandler {
	
	private final Logger logger = Logger.getLogger(WeChatInvocationProxy.class);
	
	/**
	 * 被代理的 {@code WeChat} 实例
	 */
	private WeChat weChat;

	/**
	 * 响应消息拦截器
	 */
	private ResponseInterceptor interceptor;
	
	/**
	 * 创建一个 {@code WeChat} 实例的动态代理对象
	 * @param weChat 被代理的 {@code WeChat} 实例
	 */
	public WeChatInvocationProxy(WeChat weChat) {
		this.weChat = weChat;
		interceptor = null;
	}

	/**
	 * 创建一个 {@code WeChat} 实例的动态代理对象
	 *
	 * @param weChat 被代理的 {@code WeChat} 实例
	 * @param interceptor 响应消息拦截器
	 */
	public WeChatInvocationProxy(WeChat weChat, ResponseInterceptor interceptor) {
		this.weChat = weChat;
		this.interceptor = interceptor;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		// 调用被代理对象IWeChat实例中的方法的，将返回值赋给ret
		Object ret = method.invoke(this.weChat, args);
		
		/**
		 *  判断方法的返回值是否是BaseResponse类型的：
		 *  若是，检查微信接口调用是否成功，不成功，记录错误信息，成功，则直接跳过
		 *  若不是，跳过
		 */
		if (ret instanceof BaseResponse) {
			BaseResponse response = (BaseResponse) ret;

			if (interceptor != null && interceptor.handle(response, weChat)) {

				logger.info("重新调用接口：" + method.getName());

				ret = method.invoke(weChat, args);
				if (ret instanceof BaseResponse) {
					response = (BaseResponse) ret;
				}
			}

			if (response.hasError()) {
				StringBuilder builder = new StringBuilder(55);
				builder.append("微信接口调用出错，方法名：")
					.append(method.getName())
					.append(", 错误代码： ")
					.append(response.getErrCode())
					.append(", 错误消息：")
					.append(WechatExceptionCode.ERROR_INFO.get(response.getErrCode()));
				logger.error(builder.toString());
			}
		}
		return ret;
	}

}
