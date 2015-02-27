package com.dw.ccm.wechat.base.message.response.qy;

import java.util.List;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 获取标签成员返回对象
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class TagGetResponse extends BaseResponse {
	
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
		 * 员工名称
		 */
		private String name;

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
		
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

}
