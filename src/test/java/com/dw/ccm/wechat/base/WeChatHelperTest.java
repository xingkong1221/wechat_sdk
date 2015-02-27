package com.dw.ccm.wechat.base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * 
 * @author xingkong1221
 * @date 2014年7月7日
 */
public class WeChatHelperTest{
	
	@BeforeClass
	public static void before() {
		System.out.println("测试WechatHelper...");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("测试WechatHelper结束!");
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	/**
	 * 测试获取微信接口对象
	 */
	@Test
	public void testGetWechat() {
		Assert.assertNotNull(WeChatHelper.getWeChat("wechat"));
	}
	
	/**
	 * 测试获取微信公众号的 {@code access_token}
	 */
	@Test
	public void testGetAccessToken() {
		Assert.assertFalse(WeChatHelper.getAccessToken(
				"wxd2bff322d0c25d5f", "5383aade955f01939562613bef7a2c44")
				.hasError());
	}
	
	/**
	 * 测试获取二维码地址
	 */
	@Test
	public void testGetQrCode() {
		Assert.assertNotNull(WeChatHelper.getQrCode("ticket"));
	}
	
	
}
