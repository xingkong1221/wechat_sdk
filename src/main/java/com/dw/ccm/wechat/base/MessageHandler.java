package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.InMessage;
import com.dw.ccm.wechat.base.message.PassiveMessage;

/**
 * 微信消息处理器
 * <p>处理微信服务器推送的消息。消息处理器首先会调用 {@code preHandle} 方法，对推送消息进行预先处理，
 * 接着调用特定类型的消息处理器处理特定类型的消息，处理完之后会调用 {@code postHandle} 方法，对消息进
 * 行后续的处理
 * 
 * @author xingkong1221
 * @date 2014年6月24日
 */
public interface MessageHandler {

	/**
	 * 检查是否参入的消息是否适配该消息处理器
	 *
	 * @param inMessage 微信消息
	 * @return 返回 {@code true}表示能处理该消息，返回 {@code false}表示不能处理该消息
	 */
	public boolean isAdapt(InMessage inMessage);
	
	/**
	 * 前置消息处理器
	 * <p>在消息处理器处理消息之前调用，可以对微信服务器推送的消息进行预先处理
	 * 
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 * @return 返回 {@code true} ，则继续执行后续的消息处理流程；返回 {@code false} ，
	 * 则中断此次消息处理流程（直接向微信服务器回复被动响应消息）
	 */
	public boolean preHandle(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理文本消息
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleTextMsg(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理图片消息
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleImageMsg(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理语音消息
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleVoiceMsg(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理视频消息
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleVideoMsg(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理地理位置消息
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleLocationMsg(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理链接消息
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleLinkMsg(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理订阅事件
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleSubscribeEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理取消订阅事件
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleUnsubscribeEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理二维码扫描事件
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleScanEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理地理位置时间
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleLocationEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理自定义菜单的点击事件
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleClickEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理自定义菜单的链接事件
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 待返回的被动响应消息
	 */
	public void handleViewEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 处理模板消息发送结果事件
	 *
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 带返回的被动响应消息
	 */
	public void handleTemplatesendjobfinishEvent(InMessage inMessage, PassiveMessage outMessage);
	
	/**
	 * 后置消息处理器
	 * <p>在消息处理器处理完消息之后调用，可以对消息处理器返回给微信服务器的消息进行后续的处理
	 * 
	 * @param inMessage 微信服务器推送的消息
	 * @param outMessage 带返回的被动响应消息
	 */
	public void postHandle(InMessage inMessage, PassiveMessage outMessage);
	
}
