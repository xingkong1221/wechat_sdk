package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.menu.SubButton;
import com.dw.ccm.wechat.base.message.menu.MenuMessage;
import com.dw.ccm.wechat.base.message.menu.ViewButton;
import com.dw.ccm.wechat.base.message.qy.TextCorpMessage;
import com.dw.ccm.wechat.base.message.qy.UserMessage;
import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.dw.ccm.wechat.base.message.response.qy.*;
import com.dw.ccm.wechat.base.message.response.qy.DepartListResponse.Department;
import com.dw.ccm.wechat.base.message.response.qy.UserListResponse.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信企业号接口测试
 * 
 * @author xingkong1221
 * @date 2014年9月26日
 */
public class WeChatCorpTest {
	
	private static WechatCorp wechatCorp;
	
	@BeforeClass
	public static void before() {
		wechatCorp = new WechatCorpImpl("eWm7yVBlQ9r_DcF8q2WbJqeASKYRWcB5E_Zrprctiz7Hzw3HTesiTRjNKx9lNGlH");
	}
	
	//@Test
	public void testAccessToken() {
		AccessTokenCorpResponse response = wechatCorp.getAccessToken("wx6a7e07fbc71c061f", "RyRJZcrbqyX6PFQwp1Mx0Nd08goXvxwZENY2jW0DmIOJKIdt84bc_GCOBuj7QuUh");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testCreateDepartment() {
		DepartCreateResponse response = wechatCorp.createDepartment("技术部2", "1", "2");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testUpdateDepartment() {
		DepartUpdateResponse response = wechatCorp.updateDepartment(3, "市场部", "1", "1");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testDeleteDepartment() {
		DepartDeleteResponse response = wechatCorp.deleteDepartment(2);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testListDepartment() {
		DepartListResponse response = wechatCorp.listDepartment();
		for (Department department : response.getDepartment()) {
			System.out.println(ToStringBuilder.reflectionToString(department));
		}
	}
	
	//@Test
	public void testCreateUser() {
		UserMessage userMessage = new UserMessage();
		userMessage.setUserId("lisi");
		userMessage.setName("李四");
		userMessage.setDepartment(new ArrayList<Integer>(Arrays.asList(1, 3)));
		userMessage.setPosition("产品经理");
		userMessage.setMobile("15913215421");
		userMessage.setGender(1);
		userMessage.setTel("62394");
		userMessage.setEmail("zhangsan@gzdev.com");
		userMessage.setWeixinid("zhangsan4dev");
		BaseResponse response = wechatCorp.createUser(userMessage);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testUpdateUser() {
		UserMessage userMessage = new UserMessage();
		userMessage.setUserId("lisi");
		userMessage.setName("李四");
		userMessage.setDepartment(new ArrayList<Integer>(Arrays.asList(1, 3)));
		userMessage.setPosition("产品经理");
		userMessage.setMobile("15913215421");
		userMessage.setGender(1);
		userMessage.setTel("62394");
		userMessage.setEmail("zhangsan@gzdev.com");
		userMessage.setWeixinid("zhangsan4dev");
		userMessage.setEnable(1);
		BaseResponse response = wechatCorp.updateUser(userMessage);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testDeleteUser() {
		BaseResponse response = wechatCorp.deleteUser("lisi");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testGetUser() {
		UserGetResponse response = wechatCorp.getUser("zhangsan");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}

	//@Test
	public void testListUser() {
		UserListResponse response = wechatCorp.listUser(1, 1, 0);
		System.out.println(ToStringBuilder.reflectionToString(response));
		for (User user : response.getUserlist()) {
			System.out.println(ToStringBuilder.reflectionToString(user));
		}
	}
	
	//@Test
	public void testCreateTag() {
		TagCreateResponse response = wechatCorp.createTag("美女2");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testUpdateTag() {
		BaseResponse response = wechatCorp.updateTag(1, "凉男");
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testDeleteTag() {
		BaseResponse response = wechatCorp.deleteTag(1);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testGetTag() {
		TagGetResponse response = wechatCorp.getTag(2);
		System.out.println(ToStringBuilder.reflectionToString(response));
		for (com.dw.ccm.wechat.base.message.response.qy.TagGetResponse.User user : response.getUserlist()) {
			System.out.println(ToStringBuilder.reflectionToString(user));
		}
	}
	
	//@Test
	public void testAddTagUsers() {
		TagUsersAddResponse response = wechatCorp.addTagUsers(2, new ArrayList<String>(Arrays.asList("zhangsan")));
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testDeleteTagUsers() {
		TagUsersDeleteResponse response = wechatCorp.deleteTagUsers(2, new ArrayList<String>(Arrays.asList("zhangsan")));
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	//@Test
	public void testSendMessage() {
		TextCorpMessage message = new TextCorpMessage();
		message.setToUser("zhangsan|lisi");
		message.setToParty("");
		message.setToTag("");
		message.setAgentId(1);
		message.setSafe(1);
		message.setText("Hello world111!");
		MessageCorpResponse response = wechatCorp.sendMessage(message);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
	@Test
	public void testCreateMenu() {
		MenuMessage message = new MenuMessage();
		List<SubButton> buttons = new ArrayList<SubButton>();
		ViewButton view1 = new ViewButton("淘宝", "http://www.taobao.com");
		ViewButton view2 = new ViewButton("百度", "http://www.baidu.com");
		ViewButton view3 = new ViewButton("谷歌", "http://www.google.com.hk");
		buttons.add(view1);
		buttons.add(view2);
		buttons.add(view3);
		BaseResponse response = wechatCorp.createMenu(1, message);
		System.out.println(ToStringBuilder.reflectionToString(response));
	}
	
}
