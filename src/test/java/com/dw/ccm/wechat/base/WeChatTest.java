package com.dw.ccm.wechat.base;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dw.ccm.wechat.base.message.TextMessage;
import com.dw.ccm.wechat.base.message.response.AccessTokenResponse;
import com.dw.ccm.wechat.base.message.response.CustomResponse;

/**
 * 微信接口测试
 * 
 * @author xingkong1221
 * @date 2014年7月8日
 */
public class WeChatTest {
	
	private static WeChat weChat;
	
	@BeforeClass
	public static void before() {
		AccessTokenResponse response = WeChatHelper.getAccessToken("wxd2bff322d0c25d5f", "5383aade955f01939562613bef7a2c44");
		Assert.assertFalse(response.hasError());
		weChat = WeChatHelper.getWeChat(response.getAccessToken());
	}
	
	@BeforeClass
	public static void after() {
		
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testSendCustomMessage() {
		TextMessage message = new TextMessage();
		message.setToUserName("oDZ9st1CtHywIp_64LzICgmIdBbI");
		message.setContent("测试消息");
		CustomResponse response = weChat.sendCustomMessage(message);
	}
}
