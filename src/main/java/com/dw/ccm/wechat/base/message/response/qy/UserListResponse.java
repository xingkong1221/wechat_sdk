package com.dw.ccm.wechat.base.message.response.qy;

import java.util.List;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 获取部门成员对象
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class UserListResponse extends BaseResponse {
	
	/**
	 * 成员列表
	 */
	private List<User> userlist;
	
	public static class User {
		
		/**
		 * 员工UserID
		 */
		private String userid;
		
		/**
		 * 成员名称
		 */
		private String name;

		/**
		 * 获取员工UserID
		 * @return 员工UserID
		 */
		public String getUserid() {
			return userid;
		}

		/**
		 * 设置员工UserID
		 * @param userid 员工UserID
		 */
		public void setUserid(String userid) {
			this.userid = userid;
		}
		
		/**
		 * 获取成员名称
		 * @return 成员名称
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * 设置成员名称
		 * @param name 成员名称
		 */
		public void setName(String name) {
			this.name = name;
		}
	}

	/**
	 * 获取成员列表
	 * @return 成员列表
	 */
	public List<User> getUserlist() {
		return userlist;
	}
	
	/**
	 * 设置成员列表
	 * @param userlist 成员列表
	 */
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	
}
