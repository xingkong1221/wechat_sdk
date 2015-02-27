package com.dw.ccm.wechat.base.message.response.qy;

import java.util.List;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 获取成员对象
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class UserGetResponse extends BaseResponse {
	
	/**
	 * 员工UserID
	 */
	private String userid;
	
	/**
	 * 成员名称
	 */
	private String name;
	
	/**
	 * 成员所属部门id列表
	 */
	private List<Integer> department;
	
	/**
	 * 职位信息
	 */
	private String position;
	
	/**
	 * 手机号码
	 */
	private String mobile;
	
	/**
	 * 性别。gender=0表示男，=1表示女
	 */
	private int gender;
	
	/**
	 * 办公电话
	 */
	private String tel;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 微信号
	 */
	private String weixinid;
	
	/**
	 * 头像url。注：如果要获取小图将url最后的"/0"改成"/64"即可
	 */
	private String avatar;
	
	/**
	 * 关注状态: 1=已关注，2=已冻结，4=未关注
	 */
	private int status;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
