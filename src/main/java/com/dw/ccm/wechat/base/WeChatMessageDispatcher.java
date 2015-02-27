package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.BaseMessage;
import com.dw.ccm.wechat.base.message.InMessage;
import com.dw.ccm.wechat.base.message.PassiveMessage;
import com.dw.ccm.wechat.base.utils.Asserts;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信消息的分发器
 * 
 * @author xingkong1221
 * @date 2014年6月25日
 */
public class WeChatMessageDispatcher {

	public static final Logger logger = Logger.getLogger(WeChatMessageDispatcher.class);
	
	/**
	 * 微信消息处理器
	 */
	private List<MessageHandler> handlerList;
	
	/**
	 * 实例化一个微信消息分发器
	 * 
	 * @param handler 微信消息处理器
	 */
	public WeChatMessageDispatcher(MessageHandler handler) {
		this(new ArrayList<MessageHandler>(Arrays.asList(handler)));
	}

	/**
	 * 实例化一个微信消息分发器
	 *
	 * @param handlerList 微信消息处理器
	 */
	public WeChatMessageDispatcher(List<MessageHandler> handlerList) {
		Asserts.isTrue(handlerList != null && !handlerList.isEmpty(), "微信消息分发起初始化失败，消息处理器不能为空");
		this.handlerList = handlerList;
	}
	
	/**
	 * 分发消息
	 * @param inMessage 微信服务器推送的消息
	 * @return 返回 {@code XML} 格式的被动响应消息或者空串
	 */
	public String dispatch(InMessage inMessage) {
		Asserts.notNull(inMessage, "微信服务器推送的消息不能为空");

		for (MessageHandler handler : handlerList) {
			// 检查是否适配
			if (handler.isAdapt(inMessage)) {
				// 获取微信消息类型
				String type = inMessage.getMsgType().toLowerCase();
				// 被动响应消息
				PassiveMessage passiveMessage = new PassiveMessage();

				Class<?> handlerClazz = handler.getClass();

				try {
					// 前置消息处理器方法
					Method preHandle = handlerClazz.getMethod("preHandle", InMessage.class, PassiveMessage.class);
					// 后置消息处理器方法
					Method postHandle = handlerClazz.getMethod("postHandle", InMessage.class, PassiveMessage.class);
					// 消息处理器方法
					Method handle = null;
					if ("event".equalsIgnoreCase(type)) {
						// 事件类型
						String eventType = inMessage.getEvent().toLowerCase();
						handle = handlerClazz.getMethod(
								"handle" + StringUtils.capitalize(eventType) + "Event",
								InMessage.class, PassiveMessage.class);
					} else {
						handle = handlerClazz.getMethod(
								"handle" + StringUtils.capitalize(type) + "Msg",
								InMessage.class, PassiveMessage.class);
					}

					// 调用前置消息处理器方法
					boolean ret = (Boolean) preHandle.invoke(handler, inMessage, passiveMessage);
					if (ret == false) {
						// 中断连接，向微信服务器返回被动响应消息
						return passiveMessage.toXML();
					}
					// 调用与消息类型对应的处理器
					handle.invoke(handler, inMessage, passiveMessage);

					// 调用后置消息处理器方法
					postHandle.invoke(handler, inMessage, passiveMessage);

				} catch (Exception e) {
					throw new RuntimeException("微信消息调度处理失败", e);
				}
				setOutMessageInfo(passiveMessage, inMessage);
				return passiveMessage.toXML();
			}
		}
		logger.warn("未找到微信消息处理器！");
		return "";
	}
	
	/**
	 * 设置被动响应消息的接收者和发送者
	 * @param passiveMessage 被动响应消息
	 * @param inMessage 微信推送的消息
	 */
	private void setOutMessageInfo(PassiveMessage passiveMessage, InMessage inMessage) {
		BaseMessage outMessage = passiveMessage.getMessage();
        if (outMessage != null) {
            outMessage.setFromUsername(inMessage.getToUserName());
            outMessage.setToUserName(inMessage.getFromUserName());
        }
	}
	
}
