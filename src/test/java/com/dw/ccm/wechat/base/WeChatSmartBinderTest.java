package com.dw.ccm.wechat.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dw.ccm.wechat.base.exception.WeChatException;
import com.dw.ccm.wechat.base.message.response.smartbind.WechatAccount;

/**
 * 智能绑定测试
 * 
 * @author xingkong1221
 * @date 2014年7月7日
 */
public class WeChatSmartBinderTest {
	
	/**
	 * 智能绑定对象
	 */
	private WechatSmartBinder binder;
	
	@BeforeClass
	public static void before() {
		System.out.println("智能绑定测试开始");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("智能绑定测试结束");
	}

	@Before
	public void setUp() throws Exception {
		// 初始化一个智能绑定对象
		System.out.println("创建一个WechatSmartBinder对象");
		binder = new WechatSmartBinder("yingfeng.lan@newslake.com", 
				"qwert!@#$%", 
				"http://124.17.5.223/wechat_channel/url?openid=gh_62b6c24e0e4c", 
				"5jm5mYpe4h");
		// 登录
		binder.login();
	}

	@After
	public void tearDown() throws Exception {
		binder = null;
	}

	/**
	 * 测试开启开发者模式
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException
	 */
	@Test
	public void testStartDevMode() throws WeChatException {
		binder.startDeveloperMode();
	}
	
	/**
	 * 测试微信公众号基本信息抓取t
	 */
	@Test
	public void testCrawlAccount() throws WeChatException {
		WechatAccount account = binder.crawlAccount();
		Assert.assertNotNull(account.getAddress());
	}
	
	/**
	 * 测试设置接收微信推送消息的URL
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException
	 */
	@Test
	public void testSetCallbackUrl() throws WeChatException {
		binder.setCallbackUrl();
	}
}
