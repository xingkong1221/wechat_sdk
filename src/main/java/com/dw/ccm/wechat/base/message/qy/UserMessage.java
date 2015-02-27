package com.dw.ccm.wechat.base.message.qy;

import java.util.List;

import com.dw.ccm.wechat.base.utils.JsonUtils;

/**
 * 成员
 * 
 * @author xingkong1221
 * @date 2014年9月23日
 */
public class UserMessage {
	
	public enum Type {
		/** 创建 */
		create,
		/** 更新 */
		update
	}
	
	/**
	 * 员工UserID，对应管理端的帐号，企业内必须唯一
	 */
	private String userId;
	
	/**
	 * 成员名称，长度为1~64个字符
	 */
	private String name;
	
	/**
	 * 成员所属部门id列表，注意，每个部门的直属员工上限为1000个
	 */
	private List<Integer> department;
	
	/**
	 * 职位信息，长度为0~64个字符
	 */
	private String position;
	
	/**
	 * 手机号码，企业内必须唯一，mobile/weixinid/email三者不能同时为空
	 */
	private String mobile;
	
	/**
	 * 性别，gender=0表示男，=1表示女，默认gender=0
	 */
	private int gender;
	
	/**
	 * 办公电话，长度为0~64个字符
	 */
	private String tel;
	
	/**
	 * 邮箱，长度为0~64个字符，企业内必须唯一
	 */
	private String email;
	
	/**
	 * 微信号，企业内必须唯一
	 */
	private String weixinid;
	
	/**
	 * 启用/禁用成员。1表示启用成员，0表示禁用成员
	 */
	private int enable;

	/**
	 * 将对象序列化为JSON字符串
	 * @return JSON字符串
	 */
	public String toJson(Type type) {
		if (type.equals(Type.create)) {
			String json = "{\"userid\": \"%s\",\"name\": \"%s\",\"department\": %s,\"position\": \"%s\",\"mobile\": \"%s\",\"gender\": %s,\"tel\": \"%s\",\"email\": \"%s\",\"weixinid\": \"%s\"}";
			return String.format(json, 
					userId,
					name,
					JsonUtils.toJson(department),
					position,
					mobile,
					gender,
					tel,
					email,
					weixinid
				);
		} else {
			String json = "{\"userid\": \"%s\",\"name\": \"%s\",\"department\": %s,\"position\": \"%s\",\"mobile\": \"%s\",\"gender\": %s,\"tel\": \"%s\",\"email\": \"%s\",\"weixinid\": \"%s\",\"enable\":%s}";
			return String.format(json, 
					userId,
					name,
					JsonUtils.toJson(department),
					position,
					mobile,
					gender,
					tel,
					email,
					weixinid,
					enable
				);
		}
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Integer> getDepartment() {
		return department;
	}

	public void setDepartment(List<Integer> department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}
	
}
