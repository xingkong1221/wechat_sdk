package com.dw.ccm.wechat.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import com.dw.ccm.wechat.base.message.response.template.TemplateResponse;
import com.dw.ccm.wechat.base.message.template.Attribute;
import com.dw.ccm.wechat.base.message.template.TemplateMessage;

/**
 * 模板消息测试对象
 * 
 * @author xingkong1221
 * @date 2014年9月15日
 */
public class TemplateMessageTest {
	
	private TemplateMessage message;
	
	
	@Test
	public void setUp() throws Exception {
		message = new TemplateMessage();
		message.setToUser("ToUserName");
		message.setTemplateId("XnKdlta5FWs40Fj5GjB_GRQV5wwmvZml0opsLtEWtdw");
		message.setUrl("http://www.baidu.com");
		message.setTopColor("#fff");
		message.addAttribute("first", new Attribute("您收到一条新消息", "#fff"))
			.addAttribute("ask", new Attribute("在吗", "#000"))
			.addAttribute("answer", new Attribute("在的，有什么能为您服务吗？", "#000"))
			.addAttribute("user", new Attribute("xingkong1221", "#333"))
			.addAttribute("remark", new Attribute("点击查看详情", "#303030"));
		
		System.out.println(message.toJson());
	}
	
	
	@Test
	public void send() throws Exception {
		message = new TemplateMessage();
		message.setToUser("oenujuEF2GErafc9stjlQpVER_nU");
		message.setTemplateId("5VHGS3mIJPlxzKAAwFWYzLezDLFRFVnuat3G57uWaIQ");
		message.setUrl("http://www.baidu.com");
		message.setTopColor("#ff0000");
		message.addAttribute("first", new Attribute("您好，您有新的待办任务", "#60c0ff"))
			.addAttribute("keyword1", new Attribute("张三申请年假3天", "#60c0ff"))
			.addAttribute("keyword2", new Attribute("待办", "#60c0ff"))
			.addAttribute("remark", new Attribute("请抽空处理,hahaha...", "#60c0ff"));
		WeChat weChat = WeChatHelper.getWeChat("FzkQJH4sShfKbr6tjZUeXSZjLKzabv4KhnZQ9R0pCHx0R3MZ9G3T0RYTIE6HSGFXxc2AsyjczVdLsVXKxkjK8Q");
		TemplateResponse response = weChat.sendTemplate(message);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}

}
